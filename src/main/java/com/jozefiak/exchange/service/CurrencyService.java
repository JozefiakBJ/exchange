package com.jozefiak.exchange.service;

import com.jozefiak.exchange.domain.CurrencyView;
import com.jozefiak.exchange.domain.InfoView;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
public class CurrencyService {

    private final WebClient webClient;

    public CurrencyService(WebClient.Builder webClientBuilder) {

        this.webClient = webClientBuilder.baseUrl("http://api.nbp.pl/api/exchangerates/tables/").build();
    }

    //get all currencies now
    public List<CurrencyView> getActualCurrencies()
    {

        Mono<List<InfoView>> response = webClient.get()
                .uri("/C")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<>() {});
        List<InfoView> r = response.block();

        return Objects.requireNonNull(r).stream().map(InfoView::getRates).collect(Collectors.toList()).get(0);
    }

}