package com.bootcamp.demo_real.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.bootcamp.demo_real.model.Person;
import com.bootcamp.demo_real.service.PersonPageService;

@Service
public class PersonPageServiceImpl implements PersonPageService {
  public String personpage( Model model ){
    //model.addAttribute("person", new Person());
    return "PersonPage.html";
  }
  
}
