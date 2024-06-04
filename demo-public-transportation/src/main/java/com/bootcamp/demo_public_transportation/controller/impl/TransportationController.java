package com.bootcamp.demo_public_transportation.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.demo_public_transportation.controller.TransportationOperation;
import com.bootcamp.demo_public_transportation.dto.TransportationDto;
import com.bootcamp.demo_public_transportation.dto.Mapper.TransportationDtoMapper;
import com.bootcamp.demo_public_transportation.service.TransportationService;
import com.bootcamp.demo_public_transportation.transportationEntity.TransprotationEntity;
import com.bootcamp.demo_public_transportation.transportationEntity.ValueEntity;

@RestController
public class TransportationController implements TransportationOperation {

  @Autowired
  private TransportationService tsts1;
  @Autowired 
  private TransportationDtoMapper tstdm1;


  @Override

  public TransportationDto getT_Dto(){
    return tstdm1.map(tsts1.getT());

  }

  @Override
  public List<ValueEntity> saveT_Entity(){
    return tsts1.saveT();
  }
  
}
