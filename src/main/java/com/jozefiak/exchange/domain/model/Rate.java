package com.jozefiak.exchange.domain.model;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Rate {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String currency;
    private String code;
    private double bid;
    private double ask;

}