package com.bootcamp.demo_spe1.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Service;

import com.bootcamp.demo_spe1.infra.NotFoundException;
import com.bootcamp.demo_spe1.model.Operation1;
import com.bootcamp.demo_spe1.service.CalculatorService;

@Service
public class CalculatorServiceimpl implements CalculatorService {

  @Override
  public String Caculate(String x, String y, String operation) {

     if (!("add".equals(operation) || "sub".equals(operation) || "mul".equals(operation) || "div".equals(operation))) {
      return "error";
    }

    

    try{
      double x1= Double.valueOf(x);
      double y1= Double.valueOf(y);
    }catch(NumberFormatException n){
      return "error";
    }

    if(Double.valueOf(x)==0||Double.valueOf(y)==0){
      return "error";
    }

 
    if (operation.equals("add")) {
      double x1=Double.valueOf(x);
      double y1=Double.valueOf(y);

      double test1 = BigDecimal.valueOf(x1).add(BigDecimal.valueOf(y1)).doubleValue();
      return Double.toString(test1);
    }
    if (operation.equals("sub")) {
      double x1=Double.valueOf(x);
      double y1=Double.valueOf(y);

      double test2 = BigDecimal.valueOf(x1).subtract(BigDecimal.valueOf(y1)).doubleValue();
      return Double.toString(test2);
    }
    if (operation.equals("mul")) {
      double x1=Double.valueOf(x);
      double y1=Double.valueOf(y);

      double test3 = BigDecimal.valueOf(x1).multiply(BigDecimal.valueOf(y1)).doubleValue();
      return Double.toString(test3);
    }
    if (operation.equals("div")) {
      double x1=Double.valueOf(x);
      double y1=Double.valueOf(y);

      BigDecimal bdx1= BigDecimal.valueOf(x1);
      BigDecimal bdy1= BigDecimal.valueOf(y1);

      BigDecimal result = bdx1.divide(bdy1, 5, RoundingMode.HALF_UP);
      double test4 = result.doubleValue();


      //double test4 = BigDecimal.valueOf(x1).divide(BigDecimal.valueOf(y1)).doubleValue();
      return Double.toString(test4);
    }
    return "error";

  }

  @Override
  public String Caculate2(String x, String y, String operation) throws NotFoundException {

    if (!("add".equals(operation) || "sub".equals(operation) || "mul".equals(operation) 
    || "div".equals(operation))) {
     throw new NotFoundException();
   }

   

   try{
     double x1= Double.valueOf(x);
     double y1= Double.valueOf(y);
   }catch(NumberFormatException n){
    throw new NumberFormatException();
   }

   if(Double.valueOf(x)==0||Double.valueOf(y)==0){
    throw new NumberFormatException();
   }


   if (operation.equals("add")) {
     double x1=Double.valueOf(x);
     double y1=Double.valueOf(y);

     double test1 = BigDecimal.valueOf(x1).add(BigDecimal.valueOf(y1)).doubleValue();
     return Double.toString(test1);
   }
   if (operation.equals("sub")) {
     double x1=Double.valueOf(x);
     double y1=Double.valueOf(y);

     double test2 = BigDecimal.valueOf(x1).subtract(BigDecimal.valueOf(y1)).doubleValue();
     return Double.toString(test2);
   }
   if (operation.equals("mul")) {
     double x1=Double.valueOf(x);
     double y1=Double.valueOf(y);

     double test3 = BigDecimal.valueOf(x1).multiply(BigDecimal.valueOf(y1)).doubleValue();
     return Double.toString(test3);
   }
   if (operation.equals("div")) {
     double x1=Double.valueOf(x);
     double y1=Double.valueOf(y);

     BigDecimal bdx1= BigDecimal.valueOf(x1);
     BigDecimal bdy1= BigDecimal.valueOf(y1);

     BigDecimal result = bdx1.divide(bdy1, 5, RoundingMode.HALF_UP);
     double test4 = result.doubleValue();


     //double test4 = BigDecimal.valueOf(x1).divide(BigDecimal.valueOf(y1)).doubleValue();
     return Double.toString(test4);
   }
   throw new NotFoundException();

 }

 @Override
 public String Caculate3(String x, String y, String operation) throws NotFoundException{

  try{
    double x1= Double.valueOf(x);
    double y1= Double.valueOf(y);
  }catch(NumberFormatException n){
   throw new NumberFormatException();
  }

  if(Double.valueOf(x)==0||Double.valueOf(y)==0){
   throw new NumberFormatException();
  }

  /* try{ */
 Operation1 o1= Enum.valueOf(Operation1.class, operation);
  switch (o1) {
    case add:
    double x1=Double.valueOf(x);
     double y1=Double.valueOf(y);

     double test1 = BigDecimal.valueOf(x1).add(BigDecimal.valueOf(y1)).doubleValue();
     return Double.toString(test1);
    
     case sub:
     double x2=Double.valueOf(x);
     double y2=Double.valueOf(y);

     double test2 = BigDecimal.valueOf(x2).subtract(BigDecimal.valueOf(y2)).doubleValue();
     return Double.toString(test2);

     case mul:
     double x3=Double.valueOf(x);
     double y3=Double.valueOf(y);

     double test3 = BigDecimal.valueOf(x3).multiply(BigDecimal.valueOf(y3)).doubleValue();
     return Double.toString(test3);

     case div:
     double x4=Double.valueOf(x);
     double y4=Double.valueOf(y);

     BigDecimal bdx1= BigDecimal.valueOf(x4);
     BigDecimal bdy1= BigDecimal.valueOf(y4);

     BigDecimal result = bdx1.divide(bdy1, 5, RoundingMode.HALF_UP);
     double test4 = result.doubleValue();

     return Double.toString(test4);
 default:
    throw new NotFoundException();
  }
}/* catch(NotFoundException e){
    throw new NotFoundException();
  } */



 }




