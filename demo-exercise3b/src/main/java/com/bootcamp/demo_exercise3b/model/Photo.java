package com.bootcamp.demo_exercise3b.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Photo {
  private String albumId;
  private String id;
  private String title;
  private String url;
  private String thumbnailUrl; //不做
  
}
