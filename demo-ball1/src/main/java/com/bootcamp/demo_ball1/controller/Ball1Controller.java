package com.bootcamp.demo_ball1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bootcamp.demo_ball1.dto.Ball1DTO;
import com.bootcamp.demo_ball1.exceptionForBall.BallException;

public interface Ball1Controller {

  @GetMapping(value = "/ballsize")
  Ball1DTO getBall1(@RequestParam String size,@RequestParam String color) throws BallException ;
  
}
