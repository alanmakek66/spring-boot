package com.bootcamp.demo_play.config;

import org.springframework.context.annotation.Configuration;

import lombok.Getter;

@Configuration
@Getter
public class Counter {

  private int item =5000;

  public int buyitem(int i1){
    int newitem=this.getItem()-i1;
    item=newitem;

    return this.getItem();
    

  }
  
}
