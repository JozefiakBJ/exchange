package com.jozefiak.exchange.service;

import com.jozefiak.exchange.domain.dto.CalcResponse;
import com.jozefiak.exchange.domain.dto.InfoView;
import com.jozefiak.exchange.domain.model.Rate;
import com.jozefiak.exchange.repository.InfoRepo;
import com.jozefiak.exchange.repository.RateRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CalcService {

    private final RatesService ratesService;
    private final RateRepo rateRepo;

    public CalcResponse calculate(boolean flag, String code, int amount) {
        ratesService.getActualRates();
        Rate rate  = rateRepo.findByCode(code);


        return new CalcResponse();
    }
}
