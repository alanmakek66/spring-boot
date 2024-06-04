package com.bootcamp.demo_play.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public enum Game {
  Paper("1","paper"),
  Rock("2","rock"),
  Scissors("3","scissors"),;

  private String id;
  private String desc;

  private Game(String id,String desc){
    this.id=id;
    this.desc=desc;
  }
  
}
