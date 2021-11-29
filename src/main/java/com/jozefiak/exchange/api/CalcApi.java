package com.jozefiak.exchange.api;

import com.jozefiak.exchange.domain.dto.CalcResponse;
import com.jozefiak.exchange.service.CalcService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/calc")
@Validated
public class CalcApi {

    private final CalcService calcService;

    @GetMapping("/{flag}/{code}/{amount}")
    public CalcResponse getLastRates(@PathVariable boolean flag, @PathVariable String code, @PathVariable int amount ) {
        return calcService.calculate(flag,code,amount);
    }

}
