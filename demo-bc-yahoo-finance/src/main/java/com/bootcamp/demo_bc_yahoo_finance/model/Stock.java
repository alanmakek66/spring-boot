package com.bootcamp.demo_bc_yahoo_finance.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Stock {
  private QuoteResponse quoteResponse;

  
}
