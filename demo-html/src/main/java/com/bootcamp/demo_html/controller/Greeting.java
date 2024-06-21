package com.bootcamp.demo_html.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@Controller
public class Greeting {

  @GetMapping("/t1")
    public String home(Model model) {
        String message = "Hello, Thymeleaf!";
        model.addAttribute("greet", message);
        return "greet.html";
    }
   


  
}
