package com.bootcamp.demo_bc_yahoo_finance.infa;

public class RestempeleException extends BusinessRuntimeException {
  public RestempeleException() {
    super(SysCode.API_ERROR);
   
  }

  
}
