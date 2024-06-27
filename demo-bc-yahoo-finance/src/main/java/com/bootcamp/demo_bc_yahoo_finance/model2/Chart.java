package com.bootcamp.demo_bc_yahoo_finance.model2;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Chart {
  private List<Result> result;
  private Object error;

}
