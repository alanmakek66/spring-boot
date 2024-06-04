package com.bootcamp.democa.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootcamp.democa.model.Cat;
import com.bootcamp.democa.model.Color;

@Configuration
//@Controller 
public class appconfig {
  

   //@GetMapping (value = "/c123")
  public  String sayhello(){
    return "hello";
  }

  @Bean(value = "white")
  Cat createwhiteCat(){
    return new Cat("abc", 3, List.of(Color.BLACK)); 

  }
  @Bean(value = "cat2")
  //@Primary 方法一
  Cat createwhiteCat2(){
    return new Cat("sam", 3, List.of(Color.BLACK)); 

  }
  
}
