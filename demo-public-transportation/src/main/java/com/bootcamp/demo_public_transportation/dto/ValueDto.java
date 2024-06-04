package com.bootcamp.demo_public_transportation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class ValueDto {

  private String route;
  //private String bound;
  //private String service_type;
  private String orig_en;
  private String orig_tc;
  //private String orig_sc;
  private String dest_en;
  private String dest_tc;
  //private String dest_sc;
  private String operator;
  
}
