package com.bootcamp.democa.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bootcamp.democa.model.Color;
import com.bootcamp.democa.model.Dog;

@Configuration
public class DDd {

  @Bean
   Dog dog1(){
    return new Dog("tom", Color.BLACK);
  }
  
}
