package com.bootcamp.demo_ball1.exceptionForBall;

import lombok.Getter;

@Getter
public class BusinessException extends Exception {
  private int code;

  public BusinessException(Syscode s1){
    super(s1.getMessage());
    this.code=s1.getCode();
  }


  
}
