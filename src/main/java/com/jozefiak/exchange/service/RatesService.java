package com.jozefiak.exchange.service;

import com.jozefiak.exchange.domain.RateMapper;
import com.jozefiak.exchange.domain.RateMapperImpl;
import com.jozefiak.exchange.domain.RateView;
import com.jozefiak.exchange.domain.InfoView;
import com.jozefiak.exchange.repository.RateRepo;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
public class RatesService {

    private final WebClient webClient;
    private final RateMapper rateMapper;
    private final RateRepo rateRepo;

    public RatesService(WebClient.Builder webClientBuilder, RateRepo rateRepo) {

        this.webClient = webClientBuilder.baseUrl("http://api.nbp.pl/api/exchangerates/tables/").build();
        this.rateRepo = rateRepo;
        this.rateMapper = new RateMapperImpl();
    }

    //get all currencies now
    public List<RateView> getActualRates()
    {

        Mono<List<InfoView>> response = webClient.get()
                .uri("/C")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<>() {});

        List<InfoView> r = response.block();

        List<RateView> rateViews = Objects.requireNonNull(r)
                .stream().map(InfoView::getRates)
                .collect(Collectors.toList()).get(0);

        rateRepo.saveAll(rateMapper.toRate(rateViews));

        return rateViews;
    }

}