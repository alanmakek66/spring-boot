package com.bootcamp.demo_public_transportation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.pulsar.PulsarProperties.Transaction;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bootcamp.demo_public_transportation.model.Transportation;

import com.bootcamp.demo_public_transportation.repository.ValueRepository;
import com.bootcamp.demo_public_transportation.service.TransportationService;
import com.bootcamp.demo_public_transportation.transportationEntity.TransprotationEntity;
import com.bootcamp.demo_public_transportation.transportationEntity.ValueEntity;

import com.bootcamp.demo_public_transportation.transportationEntity.mapper.ValueEntityMapper;

import jakarta.websocket.server.ServerEndpoint;

@Service
public class TransportationServerImpl implements TransportationService {

  @Autowired
  private ValueEntityMapper vem1;

  @Autowired ValueRepository valueRepository;




  @Override
  public Transportation getT(){

  String url="https://opendata.hkstp.org/park-info/v1/public-transportation";

  Transportation t1= new RestTemplate().getForObject(url, Transportation.class);

  return t1;


  }

  @Override 
  public List<ValueEntity> saveT(){

    String url="https://opendata.hkstp.org/park-info/v1/public-transportation";

  Transportation t1= new RestTemplate().getForObject(url, Transportation.class);

  vem1.map(t1);

  valueRepository.saveAll(vem1.map(t1));

  return vem1.map(t1);

  
  }


  
}
