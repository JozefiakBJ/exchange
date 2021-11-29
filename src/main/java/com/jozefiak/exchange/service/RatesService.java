package com.jozefiak.exchange.service;

import com.jozefiak.exchange.domain.dto.InfoView;
import com.jozefiak.exchange.domain.dto.RateView;
import com.jozefiak.exchange.domain.mapper.*;
import com.jozefiak.exchange.repository.InfoRepo;
import com.jozefiak.exchange.repository.RateRepo;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import java.util.List;

@Service
public class RatesService {

    private final WebClient webClient;
    private final RateRepo rateRepo;
    private final RateViewMapper rateViewMapper;
    private final InfoMapper infoMapper;
    private final InfoRepo infoRepo;

    public RatesService(WebClient.Builder webClientBuilder, RateRepo rateRepo, InfoRepo infoRepo) {

        this.webClient = webClientBuilder.baseUrl("http://api.nbp.pl/api/exchangerates/tables/").build();
        this.rateRepo = rateRepo;
        this.infoRepo = infoRepo;
        this.infoMapper = new InfoMapperImpl();
        this.rateViewMapper = new RateViewMapperImpl();

    }

    public List<InfoView> getActualRates()
    {

        Mono<List<InfoView>> response = webClient.get()
                .uri("/C")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<>() {});

        List<InfoView> r = response.block();
        infoRepo.deleteAll();
        infoRepo.saveAll(infoMapper.toInfo(r));

        return r;
    }

    public List<RateView> getAllRates()
    {
       return rateViewMapper.toRateView(rateRepo.findAll());
    }

    public RateView getRate(String code) {
        return rateViewMapper.toRateView(rateRepo.findByCode(code));
    }

}