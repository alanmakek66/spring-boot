package com.bootcamp.demo_stock2.controller;

import java.util.List;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.demo_stock2.dto.Stockdto2;

import com.bootcamp.demo_stock2.service.Stock2Service;

@RestController
public class Stock2Controller implements Stock2Opertion {

  @Autowired
  private Stock2Service ss1;

  @Override
  public List<Stockdto2> getStockdto2s(){
    return ss1.getStocks().stream().collect(Collectors.groupingBy(e->e.getStockId(),
    Collectors.summingInt(e->e.getQuantity()))).entrySet().stream()
    .map(e->new Stockdto2(e.getKey(), e.getValue())).collect(Collectors.toList());

    

  }
  
}
