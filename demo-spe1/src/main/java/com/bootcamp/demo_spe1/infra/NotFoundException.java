package com.bootcamp.demo_spe1.infra;

public class NotFoundException extends BusineseException {

  public NotFoundException(){
    super(Syscode.NOT_FOUND);
  }
  
  
}
