package com.bootcamp.demo_bc_yahoo_finance.model2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Meta {

  private String currency;

  private String symbol;

  private String exchangeName;

  private String fullExchangeName;

  private String instrumentType;

  private long firstTradeDate;

  private long regularMarketTime;

  private boolean hasPrePostMarketData;

  private int gmtoffset;

  private String timezone;

  private String exchangeTimezoneName;

  private double regularMarketPrice;

  private double fiftyTwoWeekHigh;

  private double fiftyTwoWeekLow;

  private double regularMarketDayHigh;

  private double regularMarketDayLow;

  private long regularMarketVolume;

  private double chartPreviousClose;

  private int priceHint;

  private CurrentTradingPeriod currentTradingPeriod;

  private String dataGranularity;

  private String range;

  private String[] validRanges;

}
