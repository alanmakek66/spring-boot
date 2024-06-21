package com.bootcamp.demo_the.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller  //只能是controller
public class GreetingController {
  @GetMapping(value = "/greeting")
public String greeting(@RequestParam 
String name, Model model) {
    
  model.addAttribute("name", name);
    return "greeting";
}
  
  
}
