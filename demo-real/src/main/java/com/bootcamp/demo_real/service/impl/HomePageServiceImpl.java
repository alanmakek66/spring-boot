package com.bootcamp.demo_real.service.impl;

import org.springframework.stereotype.Service;

import com.bootcamp.demo_real.service.HomePageService;

@Service
public class HomePageServiceImpl implements HomePageService {
  public String homepage(){
    return "HomePage.html";
  }
  
}
