package com.bootcamp.demoshop;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;



@Setter
@Getter

public class shop {
  private String name;
  private List<item> items;

  public shop (String name){
    this.name=name;
    this.items=new ArrayList<>();
  }
  
}
