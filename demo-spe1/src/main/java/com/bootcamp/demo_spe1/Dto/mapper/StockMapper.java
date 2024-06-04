package com.bootcamp.demo_spe1.Dto.mapper;

import org.springframework.context.annotation.Configuration;

import com.bootcamp.demo_spe1.Dto.CalculatorDTO;
import com.bootcamp.demo_spe1.model.Calculator;

@Configuration
public class StockMapper {

  public CalculatorDTO maptoCalculatorDto(Calculator c1){
    return CalculatorDTO.builder()
    .x(c1.getX())
    .y(c1.getY())
    .operation(c1.getOperation())
    .build();
  }

  
  
}
