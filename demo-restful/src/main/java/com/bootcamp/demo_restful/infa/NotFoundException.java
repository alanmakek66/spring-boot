package com.bootcamp.demo_restful.infa;
public class NotFoundException extends BusinessRuntimeException {
  public NotFoundException() {
    super(SysCode.NOT_FOUND);
  }

  // public NotFoundException(SysCode sysCode) {
  //   super(sysCode);
  // }

}
