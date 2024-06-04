package com.bootcamp.demo_spe1.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
@Builder
public class CalculatorDTO {

  private String x;
  private String y;
  private String operation ;
  private String result;
  
}
