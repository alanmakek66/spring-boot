package com.bootcamp.demo_ball1.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;


@Getter

public enum ColorForBall {
  RED("red"),
  WHITE("white"),
  
  BLACK("black"),;

  private String desc;

  private ColorForBall(String desc){
    this.desc=desc;
  }
  public String getdesc(){
    return this.desc;
  }
  
}
