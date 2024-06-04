package com.bootcamp.demo_posts1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Post {
  private String userId;
  private String id;
  private String title;
  private String body;
  
}
