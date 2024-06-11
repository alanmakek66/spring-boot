package com.bootcamp.demo_abph.dto;

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
public class PhotoDto {
  //private String albumId;
  private String id;
  private String title;
  private String url;
  private String thumbnailUrl;
  
}
