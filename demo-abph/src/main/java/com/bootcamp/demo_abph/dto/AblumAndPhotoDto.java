package com.bootcamp.demo_abph.dto;
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
public class AblumAndPhotoDto {
  private String id;
  private String title;
  private List<PhotoDto> photoDtos;
  
}
