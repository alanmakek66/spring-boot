package com.bootcamp.demo_bus.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Builder
@NoArgsConstructor
public class KmbRoute {
  private String type;
  private String version;
  private String generated_timestamp;
  private List<Data> data;


  
}
