package com.bootcamp.demo_stock2.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

import com.bootcamp.demo_stock2.dto.Stockdto2;

public interface Stock2Opertion {

  @GetMapping(value = "/getsumofstock")
  List<Stockdto2> getStockdto2s();
  
  
}
