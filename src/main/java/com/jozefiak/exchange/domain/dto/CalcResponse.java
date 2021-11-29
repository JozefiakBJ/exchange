package com.jozefiak.exchange.domain.dto;

import lombok.Data;

@Data
public class CalcResponse {

    private String info;
    private int purchaseAmount ;
    private String code;
    private double currency;
    private double convertedAmount;
}
