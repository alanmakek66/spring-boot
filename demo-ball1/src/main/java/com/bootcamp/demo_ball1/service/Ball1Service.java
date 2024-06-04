package com.bootcamp.demo_ball1.service;

import com.bootcamp.demo_ball1.dto.Ball1DTO;
import com.bootcamp.demo_ball1.exceptionForBall.BallException;
import com.bootcamp.demo_ball1.model.ColorForBall;

public interface Ball1Service {
  
  Ball1DTO calculateAndMade(String radius,String color) throws BallException;
  
}
