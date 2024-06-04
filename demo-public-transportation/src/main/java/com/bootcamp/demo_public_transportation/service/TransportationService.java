package com.bootcamp.demo_public_transportation.service;

import java.util.List;

import com.bootcamp.demo_public_transportation.model.Transportation;
import com.bootcamp.demo_public_transportation.transportationEntity.TransprotationEntity;
import com.bootcamp.demo_public_transportation.transportationEntity.ValueEntity;

public interface TransportationService {

  Transportation getT();

  List<ValueEntity> saveT();

  
  
}
