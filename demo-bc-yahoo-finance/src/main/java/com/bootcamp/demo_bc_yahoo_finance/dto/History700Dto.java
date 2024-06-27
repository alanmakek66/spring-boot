package com.bootcamp.demo_bc_yahoo_finance.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class History700Dto {
  
  private String timestamp;
  private String open;
  private String high;
  private String low;
  private String close;
  private String volume;
  
}
