package com.bootcamp.democa.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootcamp.democa.controller.DogOperation;
import com.bootcamp.democa.model.Dog;

@Controller
@ResponseBody
public class Dogcontroller implements DogOperation {
  @Autowired
  private Dog d1;


  @Override
  public Dog callDog(){
    return d1;

  }
  
}
