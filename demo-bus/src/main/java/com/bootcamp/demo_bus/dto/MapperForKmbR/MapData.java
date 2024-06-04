package com.bootcamp.demo_bus.dto.MapperForKmbR;

import org.springframework.stereotype.Component;

import com.bootcamp.demo_bus.dto.DataDto;
import com.bootcamp.demo_bus.model.Data;

@Component
public class MapData {

  public DataDto map(Data d1){
    return DataDto.builder().route(d1.getRoute())
    .bound(d1.getBound())
    .orig_en(d1.getOrig_en())
    .orig_tc(d1.getOrig_tc())
    .dest_en(d1.getDest_en())
    .dest_tc(d1.getDest_tc())
    .build();
  }
  
}
