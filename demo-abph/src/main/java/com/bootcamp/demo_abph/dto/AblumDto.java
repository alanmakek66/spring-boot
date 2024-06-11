package com.bootcamp.demo_abph.dto;

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

public class AblumDto {
  private String userId;
  private String id;
  private String title;
  
}
