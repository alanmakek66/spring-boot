package com.bootcamp.demo_spe1.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Setter
@NoArgsConstructor
@Getter
public class ErrorDTO {
  private int code;
  private String message;
  
}
