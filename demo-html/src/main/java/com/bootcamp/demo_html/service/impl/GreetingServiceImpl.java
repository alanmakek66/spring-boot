package com.bootcamp.demo_html.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.bootcamp.demo_html.service.GreetingService;

@Service
public class GreetingServiceImpl implements GreetingService {
  
   public String greeting(String message, Model model){

    model.addAttribute("greet", message);
    return "greet.html";


   }
  
}
