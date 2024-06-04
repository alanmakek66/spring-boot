package com.bootcamp.demo_dto.dto.mapper;

import org.springframework.stereotype.Component;

import com.bootcamp.demo_dto.dto.StockDto;
import com.bootcamp.demo_dto.model.Stock;

@Component
public class StockMapper {

  public  StockDto map(Stock s1){
    return StockDto.builder()
    .stockNo(s1.getId())
    .quantity(s1.getQuantity())
    .build();
  }
  
}
