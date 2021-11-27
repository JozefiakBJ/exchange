package com.jozefiak.exchange.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrencyView {

    private String currency;
    private String Code;
    private String bid;
    private String ask;

}