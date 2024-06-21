package com.bootcamp.demo_bc_yahoo_finance.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

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
public class FiveMin005Dto {
  @JsonProperty(value = "5MIN-0005.HK")
  private FiveMindata fiveMin005;
  
}
