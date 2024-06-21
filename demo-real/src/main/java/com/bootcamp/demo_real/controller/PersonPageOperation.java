package com.bootcamp.demo_real.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public interface PersonPageOperation {
  @GetMapping(value = "/person")
  String personpage( Model model );
  
}
