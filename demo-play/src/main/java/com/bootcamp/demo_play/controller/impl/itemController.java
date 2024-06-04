package com.bootcamp.demo_play.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.demo_play.controller.itemOperation;
import com.bootcamp.demo_play.service.itemService;

@RestController
public class itemController implements itemOperation{

  @Autowired itemService is1;

  @Override
  public int buy1(@RequestParam String s1) throws NumberFormatException{

    //is1.buy(s1);

    return is1.buy(s1);

  }
  
}
