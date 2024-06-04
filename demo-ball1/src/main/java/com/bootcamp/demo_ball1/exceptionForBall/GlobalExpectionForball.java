package com.bootcamp.demo_ball1.exceptionForBall;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.bootcamp.demo_ball1.dto.BallerrorDTO;

@RestControllerAdvice
public class GlobalExpectionForball {

  @ExceptionHandler(BallException.class)
  public String error(BallException b){
    return "abc";
  }
  
}
