package com.bootcamp.demo_public_transportation.transportationEntity.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.bootcamp.demo_public_transportation.dto.TransportationDto;
import com.bootcamp.demo_public_transportation.dto.ValueDto;
import com.bootcamp.demo_public_transportation.model.Transportation;
import com.bootcamp.demo_public_transportation.model.Value;
import com.bootcamp.demo_public_transportation.transportationEntity.TransprotationEntity;
import com.bootcamp.demo_public_transportation.transportationEntity.ValueEntity;

@Component
public class ValueEntityMapper {
  public List<ValueEntity> map(Transportation t1){
    List<ValueEntity> test1 =
    t1.getValue().stream().map(e->this.map1(e)).collect(Collectors.toList());
    
    return test1;
  }



  public ValueEntity map1(Value v1){
    return ValueEntity.builder()
    .route(v1.getRoute())
    .orig_en(v1.getOrig_en())
    .orig_tc(v1.getOrig_tc())
    .dest_en(v1.getDest_en())
    .dest_tc(v1.getDest_tc())
    .operator(v1.getOperator())
    .build();


  }
  
}
