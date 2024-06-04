package com.bootcamp.demo_dto.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
@NoArgsConstructor
public class Stock {
  private int id;
  private String desc;
  private int quantity;

 
  
}
