package com.bootcamp.demo_bc_yahoo_finance.entity.mapper;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;

import org.springframework.stereotype.Component;

import com.bootcamp.demo_bc_yahoo_finance.entity.YahooStockEntity;
import com.bootcamp.demo_bc_yahoo_finance.enum1.Type1;
import com.bootcamp.demo_bc_yahoo_finance.model.Stock;

@Component
public class YahooStockEntityMapper {

  public YahooStockEntity map5m(Stock s1) {
    Instant instant = Instant.ofEpochSecond(s1.getQuoteResponse().getResult().get(0).getRegularMarketTime());
    LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());

    return YahooStockEntity.builder()
        .regularMarketTime(s1.getQuoteResponse().getResult().get(0).getRegularMarketTime())
        .regularMarketPrice(s1.getQuoteResponse().getResult().get(0).getRegularMarketPrice())
        .regularMarketChangePercent(s1.getQuoteResponse().getResult().get(0).getRegularMarketChangePercent())
        .bid(s1.getQuoteResponse().getResult().get(0).getBid())
        .bidSize(s1.getQuoteResponse().getResult().get(0).getBidSize())
        .ask(s1.getQuoteResponse().getResult().get(0).getAsk())
        .askSize(s1.getQuoteResponse().getResult().get(0).getAskSize())
        .type(Type1.FiveMinutes.getSymbol())
        .apiDatetime(LocalDateTime.now())
        .MarketTime(localDateTime)
        .symbol(s1.getQuoteResponse().getResult().get(0).getSymbol())
        
        .build();

  }

  public YahooStockEntity mapdaily(Stock s1){
    Instant instant = Instant.ofEpochSecond(s1.getQuoteResponse().getResult().get(0).getRegularMarketTime());
    LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());

    return YahooStockEntity.builder()
        .regularMarketTime(s1.getQuoteResponse().getResult().get(0).getRegularMarketTime())
        .regularMarketPrice(s1.getQuoteResponse().getResult().get(0).getRegularMarketPrice())
        .regularMarketChangePercent(s1.getQuoteResponse().getResult().get(0).getRegularMarketChangePercent())
        .bid(s1.getQuoteResponse().getResult().get(0).getBid())
        .bidSize(s1.getQuoteResponse().getResult().get(0).getBidSize())
        .ask(s1.getQuoteResponse().getResult().get(0).getAsk())
        .askSize(s1.getQuoteResponse().getResult().get(0).getAskSize())
        .type(Type1.Daily.getSymbol())
        .apiDatetime(LocalDateTime.now())
        .MarketTime(localDateTime)
        .symbol(s1.getQuoteResponse().getResult().get(0).getSymbol())
        
        .build();

  }
  public YahooStockEntity mapMonth(Stock s1){
    Instant instant = Instant.ofEpochSecond(s1.getQuoteResponse().getResult().get(0).getRegularMarketTime());
    LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());

    return YahooStockEntity.builder()
        .regularMarketTime(s1.getQuoteResponse().getResult().get(0).getRegularMarketTime())
        .regularMarketPrice(s1.getQuoteResponse().getResult().get(0).getRegularMarketPrice())
        .regularMarketChangePercent(s1.getQuoteResponse().getResult().get(0).getRegularMarketChangePercent())
        .bid(s1.getQuoteResponse().getResult().get(0).getBid())
        .bidSize(s1.getQuoteResponse().getResult().get(0).getBidSize())
        .ask(s1.getQuoteResponse().getResult().get(0).getAsk())
        .askSize(s1.getQuoteResponse().getResult().get(0).getAskSize())
        .type(Type1.Monthly.getSymbol())
        .apiDatetime(LocalDateTime.now())
        .MarketTime(localDateTime)
        .symbol(s1.getQuoteResponse().getResult().get(0).getSymbol())
        
        .build();

  }

}
