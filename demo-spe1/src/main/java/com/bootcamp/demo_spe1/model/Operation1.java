package com.bootcamp.demo_spe1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public enum Operation1 {
  add("add"),
  sub("sub"),
  mul("mul"),
  div("div"),;

  private String desc;

  private Operation1(String desc){
    this.desc=desc;
  }
  
}
