package com.bootcamp.demo_helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloworld {

  @GetMapping(value = "/hello")
  String hello(){
    return "hello";
  }
  
}
