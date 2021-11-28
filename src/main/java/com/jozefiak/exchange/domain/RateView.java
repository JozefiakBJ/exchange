package com.jozefiak.exchange.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RateView {

    private String currency;
    private String code;
    private String bid;
    private String ask;

}