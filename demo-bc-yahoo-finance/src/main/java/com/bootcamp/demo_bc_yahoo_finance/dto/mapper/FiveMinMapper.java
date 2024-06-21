package com.bootcamp.demo_bc_yahoo_finance.dto.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.bootcamp.demo_bc_yahoo_finance.dto.Data1Dto;

import com.bootcamp.demo_bc_yahoo_finance.dto.FiveMindata;
import com.bootcamp.demo_bc_yahoo_finance.entity.Data005forRedis;
import com.bootcamp.demo_bc_yahoo_finance.entity.Data388forRedis;
import com.bootcamp.demo_bc_yahoo_finance.entity.Data700forRedis;
import com.bootcamp.demo_bc_yahoo_finance.entity.DataforCache;

@Component
public class FiveMinMapper {
  public Data1Dto map(DataforCache d1) {
    return Data1Dto.builder().markTime(d1.getMarketTime())
    .regularMarketChangePercent(d1.getRegularMarketChangePercent())
    .regularMarketPrice(d1.getRegularMarketPrice())
    .regularMarketUnix(d1.getRegularMarketUnix())
    .symbol(d1.getSymbol()).build();
  }
  public FiveMindata map(Data388forRedis d1){

    List<Data1Dto> data1Dtos=d1.getDataforCaches()
    .stream().map(e->this.map(e)).collect(Collectors.toList());
    return FiveMindata.builder().data1Dtos(data1Dtos)
    .build();
  }
  public FiveMindata map(Data700forRedis d1){

    List<Data1Dto> data1Dtos=d1.getDataforCaches()
    .stream().map(e->this.map(e)).collect(Collectors.toList());
    return FiveMindata.builder().data1Dtos(data1Dtos)
    .build();
  }
  public FiveMindata map(Data005forRedis d1){

    List<Data1Dto> data1Dtos=d1.getDataforCaches()
    .stream().map(e->this.map(e)).collect(Collectors.toList());
    return FiveMindata.builder().data1Dtos(data1Dtos)
    .build();
  }
  
}
