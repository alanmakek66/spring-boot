package com.bootcamp.demo_real.controller;

import org.springframework.web.bind.annotation.GetMapping;

public interface HomePageOperation {

  @GetMapping(value = "/home")
  String Homepage();
  
}
