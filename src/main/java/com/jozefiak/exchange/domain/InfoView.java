package com.jozefiak.exchange.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class InfoView {
    private String table;
    private String no;
    private String tradingDate;
    private String effectiveDate;
    private List<CurrencyView> rates;
}
