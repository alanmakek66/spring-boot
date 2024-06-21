package com.bootcamp.demo_bc_yahoo_finance.dto;

import java.time.LocalDate;

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
public class SysDate388Dto {
  @JsonProperty(value = "SYSDATE-0388.HK")
  private String sysDate;
}
