package com.bootcamp.demo_bc_yahoo_finance.dto.mapper;

import org.springframework.stereotype.Component;

import com.bootcamp.demo_bc_yahoo_finance.dto.YahooStockDto;
import com.bootcamp.demo_bc_yahoo_finance.entity.YahooStockEntity;

@Component
public class YahooStockDtoMapper {
  public YahooStockDto map(YahooStockEntity y1){
    return YahooStockDto.builder()
    .regularMarketTime(y1.getRegularMarketTime())
    .MarketTime(y1.getMarketTime())
    .regularMarketChangePercent(y1.getRegularMarketChangePercent())
    .regularMarketPrice(y1.getRegularMarketPrice())
    .symbol(y1.getSymbol())
    .MarketTime(y1.getMarketTime())
    .apiDatetime(y1.getApiDatetime())
    .ask(y1.getAsk())
    .askSize(y1.getAskSize())
    .bid(y1.getBid())
    .bidSize(y1.getBidSize())
    .type(y1.getType()).build();
  }
  
}
