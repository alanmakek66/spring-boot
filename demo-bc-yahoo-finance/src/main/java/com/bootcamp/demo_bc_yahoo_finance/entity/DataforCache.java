package com.bootcamp.demo_bc_yahoo_finance.entity;

import java.time.LocalDateTime;

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
public class DataforCache {
  private String symbol;
  private String marketTime;
  private String regularMarketUnix;
  private String regularMarketPrice;
  private String regularMarketChangePercent;
  
}
