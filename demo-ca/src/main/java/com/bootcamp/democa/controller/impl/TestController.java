package com.bootcamp.democa.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootcamp.democa.config.appconfig;
import com.bootcamp.democa.controller.TestOperation;
import com.bootcamp.democa.model.Cat;

@Controller
@ResponseBody
public class TestController implements TestOperation {
  @Autowired
  private appconfig appconfig1;
  
  @Autowired
  
  private appconfig appconfig2;

  @Autowired
  
  @Qualifier(value = "white")
  private Cat cat1;
  
  @Autowired
  @Qualifier(value = "cat2")
  private Cat cat2;
  /* @Autowired
  private appconfig appconfig1;
  private appconfig appconfig2; */
  
  @Override
  public String testSayhello(){
    return new appconfig().sayhello();

  }

  @Override
  public String testSayhello2(){
    if(appconfig1==appconfig2){
      return "yes";
    }return "no";
    //return appconfig1.sayhello();
  }
  @Override
  
  public String testSayhello3(){
    return appconfig2.sayhello();
    
  }
  @Override
  public Cat getWhiteCat(){
    return cat1;
  }

  @Override
  public Cat getcat2(){
    return cat2;
  }



  
  
}
