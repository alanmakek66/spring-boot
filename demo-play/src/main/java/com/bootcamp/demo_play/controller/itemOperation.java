package com.bootcamp.demo_play.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface itemOperation {

  @GetMapping(value = "/buy")
  int buy1(@RequestParam String s1)throws NumberFormatException;
  
  
}
