package com.bootcamp.democa.model;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor


public abstract class Person {
 
  private int idNo;
  
}
