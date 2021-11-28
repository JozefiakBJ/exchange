package com.jozefiak.exchange.api;

import com.jozefiak.exchange.domain.dto.InfoView;
import com.jozefiak.exchange.domain.dto.RateView;
import com.jozefiak.exchange.service.InfoService;
import com.jozefiak.exchange.service.RatesService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/info")
@Validated
public class InfoApi {

    private final InfoService infoService;

    @GetMapping("/{days}")
    public List<InfoView> getLastRates(@PathVariable @Min(1) @Max(7) int days ) {
        return infoService.getLastRates(days);
    }

}