package com.jozefiak.exchange.api;

import com.jozefiak.exchange.domain.dto.InfoView;
import com.jozefiak.exchange.service.InfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Date;
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

    @GetMapping("/{startDate}/{endDate}")
    public List<InfoView> getLastRates(@PathVariable("startDate")
                                           @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
                                        @PathVariable("endDate")
                                            @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        return infoService.getHistorical(startDate,endDate);
    }

}