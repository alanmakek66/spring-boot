package com.bootcamp.demo_bc_yahoo_finance.dto.mapper;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Component;

import com.bootcamp.demo_bc_yahoo_finance.dto.StocksDto;
import com.bootcamp.demo_bc_yahoo_finance.entity.StocksEntity;


@Component
public class StockDtoMapper {


  public StocksDto map(List<StocksEntity> stocksEntity){
    List<String> symbol=stocksEntity.stream().map(e->e.getSymbol())
    .collect(Collectors.toList());
    
    return StocksDto.builder()
    .symbol(symbol)
    .build();
  }
  
}
