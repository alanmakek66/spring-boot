package com.bootcamp.demo_bc_yahoo_finance.dto.mapper;

import org.springframework.stereotype.Component;

import com.bootcamp.demo_bc_yahoo_finance.dto.History005Dto;
import com.bootcamp.demo_bc_yahoo_finance.dto.History388Dto;
import com.bootcamp.demo_bc_yahoo_finance.dto.History700Dto;
import com.bootcamp.demo_bc_yahoo_finance.entity2.Historydata005Entity;
import com.bootcamp.demo_bc_yahoo_finance.entity2.Historydata388Entity;
import com.bootcamp.demo_bc_yahoo_finance.entity2.Historydata700Entity;

@Component
public class HistoryDataDtoMapper {

  public History388Dto map(Historydata388Entity h1){
    return History388Dto.builder()
    .high(h1.getHigh())
    .low(h1.getLow())
    .open(h1.getOpen())
    .timestamp(h1.getTimestamp())
    .volume(h1.getVolume())
    .close(h1.getClose())
    .build();
  }
  public History700Dto map(Historydata700Entity h1){
    return History700Dto.builder()
    .high(h1.getHigh())
    .low(h1.getLow())
    .open(h1.getOpen())
    .timestamp(h1.getTimestamp())
    .volume(h1.getVolume())
    .close(h1.getClose())
    .build();
  }
  public History005Dto map(Historydata005Entity h1){
    return History005Dto.builder()
    .high(h1.getHigh())
    .low(h1.getLow())
    .open(h1.getOpen())
    .timestamp(h1.getTimestamp())
    .volume(h1.getVolume())
    .close(h1.getClose())
    .build();
  }
  
}
