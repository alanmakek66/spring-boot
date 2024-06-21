package com.bootcamp.demo_bc_yahoo_finance.entity.mapper;

import org.springframework.stereotype.Component;


import com.bootcamp.demo_bc_yahoo_finance.entity.SysDate005Entity;

import com.bootcamp.demo_bc_yahoo_finance.entity.SysDate388Entity;

import com.bootcamp.demo_bc_yahoo_finance.entity.SysDate700Entity;
import com.bootcamp.demo_bc_yahoo_finance.entity.YahooStockEntity;

@Component
public class SysDateMapper {
  public SysDate388Entity map388(YahooStockEntity y1){
    return SysDate388Entity.builder()
    .sysDate(y1.getMarketTime().toLocalDate().toString())
    .build();

  }
  public SysDate700Entity map700(YahooStockEntity y1){
    return SysDate700Entity.builder()
    .sysDate(y1.getMarketTime().toLocalDate().toString())
    .build();

  }
  public SysDate005Entity map005(YahooStockEntity y1){
    return SysDate005Entity.builder()
    .sysDate(y1.getMarketTime().toLocalDate().toString())
    .build();

  }
  
}
