package com.bootcamp.demo_bus.dto;

import java.util.List;

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
public class KmbRouteDto {
  private String type;
  private String version;
  private String generated_timestamp;
  private List<DataDto> data;
  
}
