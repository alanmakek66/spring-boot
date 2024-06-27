package com.bootcamp.demo_bc_yahoo_finance.dto2.mapper;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.bootcamp.demo_bc_yahoo_finance.dto2.Latestprice005dto;
import com.bootcamp.demo_bc_yahoo_finance.dto2.Latestprice388dto;
import com.bootcamp.demo_bc_yahoo_finance.dto2.Latestprice700dto;
import com.bootcamp.demo_bc_yahoo_finance.entity.YahooStockEntity;

@Component
public class LatestpriceMapper {
  
   public Latestprice005dto map(List<YahooStockEntity> y1){
    Optional<YahooStockEntity> latest=
    y1.stream().filter(e->e.getSymbol().equals("0005.HK"))
    .max((d1,d2)->d1.getRegularMarketTime().compareTo(d2.getRegularMarketTime()));
   
    BigDecimal ask=BigDecimal.valueOf(Double.valueOf(latest.get().getAsk()));
    BigDecimal bid=BigDecimal.valueOf(Double.valueOf(latest.get().getBid()));


    return Latestprice005dto.builder()
    .ask(ask.toString())
    .bid(bid.toString())
    .build();
 } 
 public Latestprice700dto map2(List<YahooStockEntity> y1){
  Optional<YahooStockEntity> latest=
  y1.stream().filter(e->e.getSymbol().equals("0700.HK"))
  .max((d1,d2)->d1.getRegularMarketTime().compareTo(d2.getRegularMarketTime()));

  BigDecimal ask=BigDecimal.valueOf(Double.valueOf(latest.get().getAsk()));
    BigDecimal bid=BigDecimal.valueOf(Double.valueOf(latest.get().getBid()));



  return Latestprice700dto.builder()
  .ask(ask.toString())
  .bid(bid.toString())
  .build();
} 
public Latestprice388dto map3(List<YahooStockEntity> y1){
  Optional<YahooStockEntity> latest=
  y1.stream().filter(e->e.getSymbol().equals("0388.HK"))
  .max((d1,d2)->d1.getRegularMarketTime().compareTo(d2.getRegularMarketTime()));

  BigDecimal ask=BigDecimal.valueOf(Double.valueOf(latest.get().getAsk()));
    BigDecimal bid=BigDecimal.valueOf(Double.valueOf(latest.get().getBid()));



  return Latestprice388dto.builder()
  .ask(ask.toString())
  .bid(bid.toString())
  .build();
} 
  
}
