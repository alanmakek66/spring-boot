package com.bootcamp.democa.controller;

import org.springframework.web.bind.annotation.GetMapping;

public interface BeanOperation {


@GetMapping(value = "/getBean")

String[] getBean();
  
}
