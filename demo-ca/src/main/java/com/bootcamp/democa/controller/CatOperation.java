package com.bootcamp.democa.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

import com.bootcamp.democa.model.Cat;
import com.bootcamp.democa.model.Color;

public interface CatOperation {

  @GetMapping(value = "/cat/test")
 Cat test();

  @GetMapping(value = "/catlist/test")
   List<Cat> test1();

  @GetMapping(value = "/catarr/test")
  Cat[] test3();
  
}
