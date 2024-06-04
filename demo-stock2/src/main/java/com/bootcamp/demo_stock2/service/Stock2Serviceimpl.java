package com.bootcamp.demo_stock2.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.demo_stock2.config.SaveDate;
import com.bootcamp.demo_stock2.model.Stock;

@Service
public class Stock2Serviceimpl implements Stock2Service {
  public static Stock2Serviceimpl tests1=new Stock2Serviceimpl();

  @Autowired
  private SaveDate sd1;

  @Override 
  public List<Stock> getStocks(){
    return sd1.getUserList().stream().flatMap(e->e.getStocks().stream())
    .collect(Collectors.toList());

  }

  
  
}
