package com.jozefiak.exchange.domain;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RateMapper {

    Rate toRate(RateView books);
    List<Rate> toRate(List<RateView>  books);
}
