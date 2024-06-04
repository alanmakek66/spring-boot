package com.bootcamp.demo_public_transportation.model;

import jakarta.annotation.Generated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Value {
  private String route;
  private String bound;
  private String service_type;
  private String orig_en;
  private String orig_tc;
  private String orig_sc;
  private String dest_en;
  private String dest_tc;
  private String dest_sc;
  private String operator;




  
}
