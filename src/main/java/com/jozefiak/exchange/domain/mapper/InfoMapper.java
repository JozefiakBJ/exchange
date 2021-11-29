package com.jozefiak.exchange.domain.mapper;

import com.jozefiak.exchange.domain.dto.InfoView;
import com.jozefiak.exchange.domain.model.Info;

import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public  interface InfoMapper {

    Info toInfo(InfoView infoView);
    List<Info> toInfo(List<InfoView>  infoViews);

}