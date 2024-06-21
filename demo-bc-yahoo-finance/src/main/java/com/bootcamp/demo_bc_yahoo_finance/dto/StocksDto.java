package com.bootcamp.demo_bc_yahoo_finance.dto;

import java.util.List;

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
public class StocksDto {
  @JsonProperty(value = "stock-list")
  private List<String> symbol;
  
}
