package com.bootcamp.demo_bc_yahoo_finance.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bootcamp.demo_bc_yahoo_finance.dto.FiveMin005Dto;
import com.bootcamp.demo_bc_yahoo_finance.dto.FiveMin388Dto;
import com.bootcamp.demo_bc_yahoo_finance.dto.FiveMin700Dto;
import com.bootcamp.demo_bc_yahoo_finance.dto.StocksDto;
import com.bootcamp.demo_bc_yahoo_finance.dto.SysDate005Dto;
import com.bootcamp.demo_bc_yahoo_finance.dto.SysDate388Dto;
import com.bootcamp.demo_bc_yahoo_finance.dto.SysDate700Dto;
import com.bootcamp.demo_bc_yahoo_finance.dto.YahooStockDto;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface StockOperation {

  @GetMapping(value = "/stocklist")
  StocksDto getstocks() throws JsonProcessingException;

  /* @GetMapping(value = "/yahoo/stock")
  List<YahooStockDto> getYahooStockDtos()throws JsonProcessingException; */
  
  @GetMapping(value = "/update/stock")
  void updateStock()throws JsonProcessingException;

  @GetMapping(value = "/stock/symbol/type")
  List<YahooStockDto> getYahooStockDtosT
  (@RequestParam String symbol,@RequestParam String type)throws JsonProcessingException;

 
  @GetMapping(value = "/388/sysdate")
  SysDate388Dto getSysDate388()throws JsonProcessingException;

  @GetMapping(value = "/700/sysdate")
  SysDate700Dto getSysDate700()throws JsonProcessingException;

  @GetMapping(value = "/005/sysdate")
  SysDate005Dto getSysDate005()throws JsonProcessingException;

  @GetMapping(value = "/v1/388/data")
  FiveMin388Dto get0388Data()
  throws JsonProcessingException;

  @GetMapping(value = "/v1/700/data")
  FiveMin700Dto get0700Data()
throws JsonProcessingException;

  @GetMapping(value = "/v1/005/data")
  FiveMin005Dto get0005Data()
  throws JsonProcessingException;


  
}
