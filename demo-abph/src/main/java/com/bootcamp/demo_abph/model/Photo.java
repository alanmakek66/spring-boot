package com.bootcamp.demo_abph.model;


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
public class Photo {
  private String albumId;
  private String id;
  private String title;
  private String url;
  private String thumbnailUrl;
  
}
