package com.bootcamp.demo_real.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.bootcamp.demo_real.controller.HomePageOperation;
import com.bootcamp.demo_real.service.HomePageService;

@Controller
public class HomePageController implements HomePageOperation {
  @Autowired
  private HomePageService homePageService;

  @Override
  public String Homepage(){
    return homePageService.homepage();

  }
  
}
