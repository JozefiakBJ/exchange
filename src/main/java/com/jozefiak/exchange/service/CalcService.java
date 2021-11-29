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

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class CalcService {

    private final RatesService ratesService;
    private final RateRepo rateRepo;

    public CalcResponse calculate(boolean flag, String code, int purchaseAmount) {
        ratesService.getActualRates();
        Rate rate  = rateRepo.findByCode(code);

        double convertedAmount;
        String info = "From PLN";
        double currency;
        if(flag){
            currency = rate.getAsk();
            convertedAmount = purchaseAmount / rate.getAsk();
        }
        else{
            info = "To PLN";
            currency = rate.getBid();
            convertedAmount = purchaseAmount * rate.getBid();
        }

        CalcResponse calcResponse = new CalcResponse();
        calcResponse.setCode(code);
        calcResponse.setPurchaseAmount(purchaseAmount);
        calcResponse.setConvertedAmount(convertedAmount);
        calcResponse.setCurrency(currency);
        calcResponse.setInfo(info);

        return calcResponse;
    }
}