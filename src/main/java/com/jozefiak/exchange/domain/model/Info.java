package com.jozefiak.exchange.domain.model;

import com.jozefiak.exchange.domain.dto.RateView;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Info {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String tradingDate;
    private String effectiveDate;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Rate> rates = new ArrayList<>();
}