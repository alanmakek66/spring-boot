package com.bootcamp.democa.controller;

import org.springframework.web.bind.annotation.GetMapping;

import com.bootcamp.democa.model.Dog;

public interface DogOperation {
  @GetMapping(value = "/getDog")
  public Dog callDog();
  


  
}
