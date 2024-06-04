package com.bootcamp.demo_bus.dto.MapperForKmbR;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.bootcamp.demo_bus.dto.DataDto;
import com.bootcamp.demo_bus.dto.KmbRouteDto;
import com.bootcamp.demo_bus.model.Data;
import com.bootcamp.demo_bus.model.KmbRoute;

@Component
public class MapKmbRoute {

  public KmbRouteDto map(KmbRoute k1) {
    List<DataDto> result = k1.getData().stream()//
        .map(e -> this.map1(e))//
        .collect(Collectors.toList());

    return KmbRouteDto.builder()
        .type(k1.getType())
        .version(k1.getVersion())
        .generated_timestamp(k1.getGenerated_timestamp())
        .data(result)
        .build();
  }

  public DataDto map1(Data d1) {
    return DataDto.builder()//
        .route(d1.getRoute())
        .bound(d1.getBound())
        
        .orig_en(d1.getOrig_en())
        .orig_tc(d1.getOrig_tc())
        
        .orig_en(d1.getOrig_en())
        .dest_en(d1.getDest_en())
        .dest_tc(d1.getDest_tc())
        
        
        .build();

  }
}
