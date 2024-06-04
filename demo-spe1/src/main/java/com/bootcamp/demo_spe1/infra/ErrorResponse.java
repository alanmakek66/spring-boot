package com.bootcamp.demo_spe1.infra;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorResponse {
  private int code;
  private String desc;

  public static ErrorResponse of(int code,String desc){
    return new ErrorResponse(code, desc);
  }
  
}
