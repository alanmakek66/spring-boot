package com.bootcamp.demo_bc_yahoo_finance.controller;

import org.springframework.web.bind.annotation.GetMapping;

import com.bootcamp.demo_bc_yahoo_finance.dto2.Latestprice005dto;
import com.bootcamp.demo_bc_yahoo_finance.dto2.Latestprice388dto;
import com.bootcamp.demo_bc_yahoo_finance.dto2.Latestprice700dto;

public interface LatestpriceOperation {

  @GetMapping(value = "/latest005")
  Latestprice005dto latest005();

  @GetMapping(value = "/latest700")
  Latestprice700dto latest700();

  @GetMapping(value = "/latest388")
  Latestprice388dto latest388();
  
}
