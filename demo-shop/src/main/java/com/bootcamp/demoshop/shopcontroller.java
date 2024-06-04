package com.bootcamp.demoshop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody

public class shopcontroller {

  @GetMapping(value = "/shop/{name}")
  public shop createshop(@PathVariable(value = "name") String name){
    shop s1= new shop(name);
    return s1;

  }

  
}
