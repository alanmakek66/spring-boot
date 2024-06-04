package com.bootcamp.democa.controller.impl;

import java.beans.JavaBean;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootcamp.democa.controller.CatOperation;
import com.bootcamp.democa.model.Cat;
import com.bootcamp.democa.model.Color;

@ResponseBody
@Controller
public class CatController implements CatOperation {

  //@GetMapping(value = "/cat/test")
  @Override
  public Cat test(){
    return new Cat("sam", 1, new ArrayList<>(List.of(Color.BLACK,Color.RED)));
  }

  //@GetMapping(value = "/catlist/test")
  @Override
  public List<Cat> test1(){
    
    return new ArrayList<>(List.of(new Cat("abc", 13,new ArrayList<>(List.of(Color.BLACK,Color.RED)))
    ,new Cat("cda", 23,new ArrayList<>(List.of(Color.BLACK,Color.RED)))));
  }

  //@GetMapping(value = "/catarr/test")
  @Override
  public Cat[] test3(){
    
    return new Cat[]{new Cat("abc", 13,new ArrayList<>(List.of(Color.BLACK,Color.RED)))
    ,new Cat("cda", 23,new ArrayList<>(List.of(Color.BLACK,Color.RED)))
    ,new Cat("aaa", 33,new ArrayList<>(List.of(Color.BLACK,Color.RED)))};
  }


  
}
