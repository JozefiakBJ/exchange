package com.jozefiak.exchange.api;

import com.jozefiak.exchange.domain.dto.InfoView;
import com.jozefiak.exchange.domain.dto.RateView;
import com.jozefiak.exchange.service.RatesService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/rates")
public class RatesApi {
    
    private final RatesService ratesService;

    @GetMapping
    public List<InfoView> getActual() {
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