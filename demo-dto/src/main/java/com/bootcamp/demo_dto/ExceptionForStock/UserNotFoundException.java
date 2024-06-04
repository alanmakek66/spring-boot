package com.bootcamp.demo_dto.ExceptionForStock;

import com.bootcamp.demo_dto.infa.BusinessRuntimeException;
import com.bootcamp.demo_dto.infa.SysCode;

public class UserNotFoundException extends BusinessRuntimeException {

  public UserNotFoundException() {
    super(SysCode.USER_ID_NOT_FOUND);
  }
}