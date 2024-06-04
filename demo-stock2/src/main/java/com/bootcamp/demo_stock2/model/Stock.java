package com.bootcamp.demo_stock2.model;

import java.util.concurrent.atomic.AtomicLong;

import lombok.Getter;

@Getter
public class Stock {
  private static AtomicLong count=new AtomicLong(1);


  private long StockId;
  private int quantity;

  public Stock(int quantity){
    this.StockId=count.getAndIncrement();
    this.quantity=quantity;
  }


  
}
