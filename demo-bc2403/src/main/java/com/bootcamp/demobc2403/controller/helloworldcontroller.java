package com.bootcamp.demobc2403.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class helloworldcontroller {
  //api

  @GetMapping(value = "/hello") //URI -> resource identifier
  public String hello() {
    return "hello world+123";
    
  }

  @GetMapping(value = "/hello2") 
  public String hello2() {
    return "hello2";
    
  }

  public static void main(String[] args) {
    helloworldcontroller h1 = new helloworldcontroller();
    System.out.println(h1.hello());
  }

}
