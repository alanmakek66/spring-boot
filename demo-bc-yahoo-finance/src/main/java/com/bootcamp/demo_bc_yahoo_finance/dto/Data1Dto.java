package com.bootcamp.demo_bc_yahoo_finance.dto;

import java.time.LocalDateTime;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Data1Dto {
  private String symbol;
  private String markTime;
  private String regularMarketUnix;
  private String regularMarketPrice;
  private String regularMarketChangePercent;
   
  
}
