package com.bootcamp.demo_real.controller.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.demo_real.controller.PersonPageOperation;
import com.bootcamp.demo_real.service.PersonPageService;

@Controller
public class PersonPageController implements PersonPageOperation{

  @Autowired
  private PersonPageService pageService;
  
  public String personpage( Model model ){
    return pageService.personpage( model);

  }
  
}
