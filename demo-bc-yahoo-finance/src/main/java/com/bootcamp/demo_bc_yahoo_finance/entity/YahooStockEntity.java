package com.bootcamp.demo_bc_yahoo_finance.entity;

import java.time.LocalDateTime;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tst_quote_yahoo")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class YahooStockEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

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
