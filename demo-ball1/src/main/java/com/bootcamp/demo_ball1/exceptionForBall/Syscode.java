package com.bootcamp.demo_ball1.exceptionForBall;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter


public enum Syscode {

  OK(0, "success."), //
  NOT_FOUND(1, "not found."), //
  ;

  private int code;
  private String message;

  private Syscode(int code, String message){
    this.code=code;
    this.message=message;
  }

  


  
}
