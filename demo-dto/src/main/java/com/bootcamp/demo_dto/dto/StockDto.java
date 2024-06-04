package com.bootcamp.demo_dto.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// DTO stands for Data Transfer Object
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Setter
@Builder
public class StockDto {
  private int stockNo;
  private int quantity;
}