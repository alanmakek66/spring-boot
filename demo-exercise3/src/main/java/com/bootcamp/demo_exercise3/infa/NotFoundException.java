package com.bootcamp.demo_exercise3.infa;
public class NotFoundException extends BusinessRuntimeException {
  public NotFoundException() {
    super(SysCode.NOT_FOUND);
  }

  // public NotFoundException(SysCode sysCode) {
  //   super(sysCode);
  // }

}
