package com.jozefiak.exchange.domain.mapper;

import com.jozefiak.exchange.domain.dto.InfoView;
import com.jozefiak.exchange.domain.dto.RateView;
import com.jozefiak.exchange.domain.model.Info;
import com.jozefiak.exchange.domain.model.Rate;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class InfoViewMapper {

    public abstract List<InfoView> toInfoView(List<Info> info);
    public abstract InfoView toInfoView(Info info);
}
