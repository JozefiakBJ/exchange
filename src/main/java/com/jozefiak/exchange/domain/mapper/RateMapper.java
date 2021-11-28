package com.jozefiak.exchange.domain.mapper;

import com.jozefiak.exchange.domain.model.Rate;
import com.jozefiak.exchange.domain.dto.RateView;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RateMapper {

    Rate toRate(RateView rateView);
    List<Rate> toRate(List<RateView>  rateViews);

}
