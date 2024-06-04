package com.bootcamp.demo_public_transportation.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Transportation {
  private List<Value> value;
  
}
