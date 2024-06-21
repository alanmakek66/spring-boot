package com.bootcamp.demo_bc_yahoo_finance.infa;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter

public enum Scheme {
  HTTPS("https"),
  HTTP("http"),
  ;

  private String value;
  
  private Scheme (String value){
    this.value=value;
  }
  
}
