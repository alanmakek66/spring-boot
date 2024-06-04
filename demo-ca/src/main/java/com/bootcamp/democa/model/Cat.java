package com.bootcamp.democa.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString

@Getter
public class Cat {
  private String name;
  private int age;
  private List<Color> color;
  
}
