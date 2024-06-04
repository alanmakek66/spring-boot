package com.bootcamp.demo_ball1.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.demo_ball1.controller.Ball1Controller;
import com.bootcamp.demo_ball1.dto.Ball1DTO;
import com.bootcamp.demo_ball1.exceptionForBall.BallException;
import com.bootcamp.demo_ball1.service.Ball1Service;

@RestController
public class Ball1ControllerImpl implements Ball1Controller {

  @Autowired
  private Ball1Service b1s;

  @Override
  public Ball1DTO getBall1(@RequestParam String size
  ,@RequestParam String color) throws BallException{

    

    return b1s.calculateAndMade(size, color);



  }
  
}
