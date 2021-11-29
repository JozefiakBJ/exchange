package com.jozefiak.exchange.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RateView {

    private String currency;
    private String code;
    private double ask;
    private double bid;

}