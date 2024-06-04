package com.bootcamp.democa.controller.impl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootcamp.democa.DemoCaApplication;
import com.bootcamp.democa.controller.BeanOperation;

@Controller
@ResponseBody
public class Beancontroller implements BeanOperation {
  
  @Override
  public String[] getBean(){
    return DemoCaApplication.getContext().getBeanDefinitionNames();
  }

}
