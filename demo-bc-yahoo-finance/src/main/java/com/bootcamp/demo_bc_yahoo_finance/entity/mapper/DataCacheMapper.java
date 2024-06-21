package com.bootcamp.demo_bc_yahoo_finance.entity.mapper;

import java.util.List;

import org.springframework.stereotype.Component;



import com.bootcamp.demo_bc_yahoo_finance.entity.DataforCache;
import com.bootcamp.demo_bc_yahoo_finance.entity.YahooStockEntity;

@Component
public class DataCacheMapper {
  public DataforCache map(YahooStockEntity y1){
    return DataforCache.builder()
    .symbol(y1.getSymbol())
    .marketTime(y1.getMarketTime().toString())
    .regularMarketUnix(Long.valueOf(y1.getRegularMarketTime()).toString())
    .regularMarketChangePercent(Double.valueOf(y1.getRegularMarketChangePercent()).toString())
    .regularMarketPrice(Double.valueOf(y1.getRegularMarketPrice()).toString())
    .build();
    
    
    

  }

  
}
