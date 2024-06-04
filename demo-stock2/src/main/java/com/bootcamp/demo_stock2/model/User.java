package com.bootcamp.demo_stock2.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class User {


private String name;
private List<Stock> stocks;

public User(String name){
  this.name=name;
  this.stocks=new ArrayList<>();
}

public void  add(Stock s1){
  this.stocks.add(s1);
}
  
}
