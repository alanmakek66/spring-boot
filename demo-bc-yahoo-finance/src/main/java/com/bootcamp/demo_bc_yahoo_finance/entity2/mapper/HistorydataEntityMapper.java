package com.bootcamp.demo_bc_yahoo_finance.entity2.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bootcamp.demo_bc_yahoo_finance.entity2.Historydata005Entity;
import com.bootcamp.demo_bc_yahoo_finance.entity2.Historydata388Entity;
import com.bootcamp.demo_bc_yahoo_finance.entity2.Historydata700Entity;
import com.bootcamp.demo_bc_yahoo_finance.model2.HistoryData;

@Component
public class HistorydataEntityMapper {
  public List<Historydata388Entity> map(HistoryData h1){
   List<String> timeStamp= h1.getChart().getResult().get(0).getTimestamp();
   List<String> high=h1.getChart().getResult().get(0).getIndicators().getQuote().get(0)
   .getHigh();
   List<String> low=h1.getChart().getResult().get(0).getIndicators().getQuote().get(0)
   .getLow();
   List<String> open=h1.getChart().getResult().get(0).getIndicators().getQuote().get(0)
   .getOpen();
   List<String> volume=h1.getChart().getResult().get(0).getIndicators().getQuote().get(0)
   .getVolume();
   List<String> close=h1.getChart().getResult().get(0).getIndicators().getQuote().get(0)
   .getClose();

   List<Historydata388Entity> resultForEntity=new ArrayList<>();

   for(int i=0;i<timeStamp.size();i++){
    Historydata388Entity hh= Historydata388Entity.builder()
    .high(high.get(i))
    .low(low.get(i))
    .open(open.get(i))
    .timestamp(timeStamp.get(i))
    .volume(volume.get(i))
    .close(close.get(i))
    .build();
    resultForEntity.add(hh);
 }
   return resultForEntity;

  }

  public List<Historydata700Entity> map2(HistoryData h1){
    List<String> timeStamp= h1.getChart().getResult().get(0).getTimestamp();
    List<String> high=h1.getChart().getResult().get(0).getIndicators().getQuote().get(0)
    .getHigh();
    List<String> low=h1.getChart().getResult().get(0).getIndicators().getQuote().get(0)
    .getLow();
    List<String> open=h1.getChart().getResult().get(0).getIndicators().getQuote().get(0)
    .getOpen();
    List<String> volume=h1.getChart().getResult().get(0).getIndicators().getQuote().get(0)
    .getVolume();
    List<String> close=h1.getChart().getResult().get(0).getIndicators().getQuote().get(0)
    .getClose();
 
    List<Historydata700Entity> resultForEntity=new ArrayList<>();
 
    for(int i=0;i<timeStamp.size();i++){
     Historydata700Entity hh= Historydata700Entity.builder()
     .high(high.get(i))
     .low(low.get(i))
     .open(open.get(i))
     .timestamp(timeStamp.get(i))
     .volume(volume.get(i))
     .close(close.get(i))
     .build();
     resultForEntity.add(hh);
  }
    return resultForEntity;
 
   }

   public List<Historydata005Entity> map3(HistoryData h1){
    List<String> timeStamp= h1.getChart().getResult().get(0).getTimestamp();
    List<String> high=h1.getChart().getResult().get(0).getIndicators().getQuote().get(0)
    .getHigh();
    List<String> low=h1.getChart().getResult().get(0).getIndicators().getQuote().get(0)
    .getLow();
    List<String> open=h1.getChart().getResult().get(0).getIndicators().getQuote().get(0)
    .getOpen();
    List<String> volume=h1.getChart().getResult().get(0).getIndicators().getQuote().get(0)
    .getVolume();

    List<String> close=h1.getChart().getResult().get(0).getIndicators().getQuote().get(0)
    .getClose();
 
    List<Historydata005Entity> resultForEntity=new ArrayList<>();
 
    for(int i=0;i<timeStamp.size();i++){
     Historydata005Entity hh= Historydata005Entity.builder()
     .high(high.get(i))
     .low(low.get(i))
     .open(open.get(i))
     .timestamp(timeStamp.get(i))
     .close(close.get(i))
     .volume(volume.get(i))
     .build();
     resultForEntity.add(hh);
  }
    return resultForEntity;
 
   }
  
  
}
