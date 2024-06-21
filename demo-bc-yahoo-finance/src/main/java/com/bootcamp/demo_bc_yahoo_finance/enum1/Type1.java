package com.bootcamp.demo_bc_yahoo_finance.enum1;

import lombok.Getter;

@Getter

public enum Type1 {
  FiveMinutes("5min"),
  Daily("D"),
  Weekly("W"),
  Monthly("M"),
  ;

  private String symbol;
  
  private Type1(String symbol){

    this.symbol=symbol;
 }
  
}
