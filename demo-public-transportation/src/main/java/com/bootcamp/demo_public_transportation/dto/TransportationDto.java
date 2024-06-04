package com.bootcamp.demo_public_transportation.dto;

import java.util.List;

import com.bootcamp.demo_public_transportation.model.Value;

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
public class TransportationDto {
  private List<ValueDto> value;
  
}
