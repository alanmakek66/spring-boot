package com.bootcamp.demo_dto.model;

import java.util.ArrayList;
import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class User {
  private int id;
  private List<Stock> stocks;

  public User(){
    this.id++;
    this.stocks=new ArrayList<>();
  }

  public boolean add(Stock s1){
    return this.stocks.add(s1);
  }
  
}
