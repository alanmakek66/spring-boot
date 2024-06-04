package com.bootcamp.demo_ball1.service.impl;



import org.springframework.stereotype.Service;

import com.bootcamp.demo_ball1.dto.Ball1DTO;
import com.bootcamp.demo_ball1.exceptionForBall.BallException;
import com.bootcamp.demo_ball1.model.ColorForBall;
import com.bootcamp.demo_ball1.service.Ball1Service;

@Service
public class Ball1ServiceImpl implements Ball1Service {

  @Override
  public Ball1DTO calculateAndMade(String radius,String color) throws BallException{
    try{
      double d1= Double.valueOf(radius);
    }catch(NumberFormatException n){
      throw new BallException();
    }
    if(!(color.equalsIgnoreCase(ColorForBall.BLACK.getdesc()))
    &&(color.equalsIgnoreCase(ColorForBall.RED.getdesc()))&&
    (color.equalsIgnoreCase(ColorForBall.WHITE.getdesc()))){
      throw new BallException();
    }
    

    switch (color.toLowerCase()) {
      case "black":
      return new Ball1DTO(Double.valueOf(radius), ColorForBall.BLACK);
     
     case "red":
      return new Ball1DTO(Double.valueOf(radius), ColorForBall.RED);
      
      case "white":
      return new Ball1DTO(Double.valueOf(radius), ColorForBall.WHITE);
      
      default:
      throw new BallException();
    
     
        
    }

    
  
}

}
