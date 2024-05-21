package com.bootcamp.democa.controller;

import java.math.BigDecimal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class Ca {
  private final static int[] arr=new int[]{3,5,-10};
  
  @GetMapping(value = "/mltiply")
  public int mltiply(@RequestParam(value = "a") int a, @RequestParam(value = "b") int b) {
    return a * b;
  }

  @GetMapping(value = "/sum/double")
  public String sum2(@RequestParam String q,@RequestParam String p){
    double p2=0.0d;
    double q2=0.0d;
    try{
      p2=Double.valueOf(p);
      q2=Double.valueOf(q);
    }catch(NumberFormatException n){
      return "both q and p should be numbers";
    }
    return BigDecimal.valueOf(p2).add(BigDecimal.valueOf(q2)).toString();
    


  }
  
  



  

  

}
