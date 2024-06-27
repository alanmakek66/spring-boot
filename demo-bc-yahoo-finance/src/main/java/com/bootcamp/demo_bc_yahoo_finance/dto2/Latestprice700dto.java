package com.bootcamp.demo_bc_yahoo_finance.dto2;

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
public class Latestprice700dto {
  private String ask;
  private String bid;
  
}
