package com.bootcamp.demo_bc_yahoo_finance.infa;

public class SymbolNotFoundException extends BusinessRuntimeException  {

  public SymbolNotFoundException(){
    super(SysCode.SB_NOTFOUND);

  }

  
}
