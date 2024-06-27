package com.bootcamp.demo_bc_yahoo_finance.service;

import java.util.List;

import com.bootcamp.demo_bc_yahoo_finance.entity.Data005forRedis;
import com.bootcamp.demo_bc_yahoo_finance.entity.Data388forRedis;
import com.bootcamp.demo_bc_yahoo_finance.entity.Data700forRedis;
import com.bootcamp.demo_bc_yahoo_finance.entity.StocksEntity;
import com.bootcamp.demo_bc_yahoo_finance.entity.SysDate005Entity;
import com.bootcamp.demo_bc_yahoo_finance.entity.SysDate388Entity;
import com.bootcamp.demo_bc_yahoo_finance.entity.SysDate700Entity;
import com.bootcamp.demo_bc_yahoo_finance.entity.YahooStockEntity;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface StockService {

  List<StocksEntity> list() throws JsonProcessingException;

  void addDate();

  List<YahooStockEntity> get5mindate(String symbol, String type) throws JsonProcessingException;

  void update5mindata();

  void updateDailydata();



  void cleanAllSysDate();

  SysDate388Entity getSysDate388(String symbol) throws JsonProcessingException;

  SysDate700Entity getSysDate700(String symbol) throws JsonProcessingException;

  SysDate005Entity getSysDate005(String symbol) throws JsonProcessingException;

  Data388forRedis getDataforRedis388() throws JsonProcessingException;

  Data700forRedis getDataforRedis700() throws JsonProcessingException;

  Data005forRedis getDataforRedis005() throws JsonProcessingException;

  

  

}
