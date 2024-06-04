package com.bootcamp.demo_public_transportation.dto.Mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.bootcamp.demo_public_transportation.dto.TransportationDto;
import com.bootcamp.demo_public_transportation.dto.ValueDto;
import com.bootcamp.demo_public_transportation.model.Transportation;
import com.bootcamp.demo_public_transportation.model.Value;



@Component
public class TransportationDtoMapper {

  public TransportationDto map(Transportation t1){
    List<ValueDto> result= t1.getValue().stream()
    .map(e->this.map(e)).collect(Collectors.toList());

    return  TransportationDto.builder()
    .value(result)
    .build();

  }



  public ValueDto map(Value v1){
    return ValueDto.builder()
    .route(v1.getRoute())
    .orig_en(v1.getOrig_en())
    .orig_tc(v1.getOrig_tc())
    .dest_en(v1.getDest_en())
    .dest_tc(v1.getDest_tc())
    .operator(v1.getOperator())
    .build();


  }
  
}
