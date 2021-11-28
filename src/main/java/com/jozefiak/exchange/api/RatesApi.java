package com.jozefiak.exchange.api;

import com.jozefiak.exchange.domain.RateView;
import com.jozefiak.exchange.service.RatesService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RatesApi {
    
    private final RatesService ratesService;

    @GetMapping
    public List<RateView> getActual() {
        return ratesService.getActualRates();
    }

    @GetMapping("/all")
    public List<RateView> getAllRates() {
        return ratesService.getAllRates();
    }

    @GetMapping("/{code}")
    public RateView getRate(@PathVariable String code) {
        return ratesService.getRate(code);
    }

}