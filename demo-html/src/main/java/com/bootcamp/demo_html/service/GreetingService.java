package com.bootcamp.demo_html.service;

import org.springframework.ui.Model;

public interface GreetingService {

  String greeting(String message, Model model);
  
  
}
