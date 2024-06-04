package com.bootcamp.democa.model;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter

public class Customer {
  private String name;
  private String joinDate;
  private List<Order> orders;

  
}
