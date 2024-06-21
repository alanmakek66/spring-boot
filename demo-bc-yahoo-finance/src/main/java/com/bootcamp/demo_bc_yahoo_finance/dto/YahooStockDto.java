package com.bootcamp.demo_bc_yahoo_finance.dto;

import java.time.LocalDateTime;
import java.util.List;

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
public class YahooStockDto {
  private String symbol;
  private Long regularMarketTime;

  private double regularMarketPrice;
  private double regularMarketChangePercent;

  private double bid;
  private int bidSize;

  private double ask;
  private int askSize;

  private String type;
  private LocalDateTime apiDatetime;
  private LocalDateTime MarketTime;
  
}
