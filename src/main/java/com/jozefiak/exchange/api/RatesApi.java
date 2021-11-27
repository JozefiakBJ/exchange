package com.jozefiak.exchange.api;

import com.jozefiak.exchange.domain.RateView;
import com.jozefiak.exchange.service.RatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RatesApi {

    @Autowired
    private RatesService ratesService;

    @GetMapping
    public List<RateView> getActual() {
        return ratesService.getActualRates();
    }
}