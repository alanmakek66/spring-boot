package com.bootcamp.demo_allinone.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Setter
@NoArgsConstructor
@Getter
public class Post {
  private String userId;
  private String id;
  private String title;
  private String body;
  
}
