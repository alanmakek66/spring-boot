package com.bootcamp.demo_public_transportation.controller;



import java.util.List;

import com.bootcamp.demo_public_transportation.dto.TransportationDto;
import com.bootcamp.demo_public_transportation.transportationEntity.TransprotationEntity;
import com.bootcamp.demo_public_transportation.transportationEntity.ValueEntity;


public interface TransportationOperation {

  TransportationDto getT_Dto();

  List<ValueEntity> saveT_Entity();
  
}
