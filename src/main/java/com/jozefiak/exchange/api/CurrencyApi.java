package com.jozefiak.exchange.api;

import com.jozefiak.exchange.domain.CurrencyView;
import com.jozefiak.exchange.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CurrencyApi {

    @Autowired
    private CurrencyService currencyService;

    @GetMapping
    public List<CurrencyView> getActual() {
        return currencyService.getActualCurrencies();
    }
}