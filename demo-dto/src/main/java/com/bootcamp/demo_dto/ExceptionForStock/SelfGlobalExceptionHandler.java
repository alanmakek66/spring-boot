package com.bootcamp.demo_dto.ExceptionForStock;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.demo_dto.infa.BusinessRuntimeException;
import com.bootcamp.demo_dto.infa.ErrorResponse;
import com.bootcamp.demo_dto.infa.GlobalExceptionHandler;

@RestController // bean
public class SelfGlobalExceptionHandler extends GlobalExceptionHandler {

  // try to catch NotFoundException
  // if it is caught, call this java method, it passes the input parameter as well.

  // @ExceptionHandler(NotFoundException.class) // catch
  // public ErrorResponse notFoundExceptionHandler(NotFoundException e) {
  // return new ErrorResponse(e.getCode(), e.getMessage());
  // }

  // @ExceptionHandler(UserNotFoundException.class) // catch
  // public ErrorResponse userNotFoundExceptionHandler(UserNotFoundException e) {
  // return new ErrorResponse(e.getCode(), e.getMessage());
  // }

  @ExceptionHandler(BusinessRuntimeException.class)
  public ErrorResponse businessRuntimeExceptionHandler(
      BusinessRuntimeException e) {
    return new ErrorResponse(e.getCode(), e.getMessage());
  }

}
