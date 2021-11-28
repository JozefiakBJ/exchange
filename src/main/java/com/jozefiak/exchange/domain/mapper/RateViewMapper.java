package com.jozefiak.exchange.domain.mapper;

import com.jozefiak.exchange.domain.model.Rate;
import com.jozefiak.exchange.domain.dto.RateView;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class RateViewMapper {

    public abstract List<RateView> toRateView(List<Rate> rate);
    public abstract RateView toRateView(Rate rate);
}
