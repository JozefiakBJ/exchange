package com.jozefiak.exchange.domain;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RateMapper {

    Rate toRate(RateView rateView);
    List<Rate> toRate(List<RateView>  rateViews);
    List<RateView> toRateView(List<Rate> rate);
    RateView toRateView(Rate rate);
}
