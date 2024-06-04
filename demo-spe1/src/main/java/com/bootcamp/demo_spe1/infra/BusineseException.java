package com.bootcamp.demo_spe1.infra;

import lombok.Getter;

@Getter
public class BusineseException extends Exception {
  private int code;

  public BusineseException(Syscode sc1) {
    super(sc1.getDesc());
    this.code=sc1.getCode();
    
  }
  
}
