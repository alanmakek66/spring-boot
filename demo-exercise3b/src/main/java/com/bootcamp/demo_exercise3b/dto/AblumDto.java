package com.bootcamp.demo_exercise3b.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Id;
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
  private Long id;
  private String title;
  @JsonProperty(value = "photo")
  private List<PhotoDto> photoDtos;

  
}
