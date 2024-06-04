package com.bootcamp.demo_dto.ExceptionForStock;

;
import com.bootcamp.demo_dto.infa.BusinessException;
import com.bootcamp.demo_dto.infa.BusinessRuntimeException;
import com.bootcamp.demo_dto.infa.SysCode;

public class ListAddException extends BusinessRuntimeException {

  public ListAddException() {
    super(SysCode.LIST_ADD_FAIL);
  }
}
