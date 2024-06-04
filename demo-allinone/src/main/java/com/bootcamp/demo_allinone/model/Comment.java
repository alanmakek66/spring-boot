package com.bootcamp.demo_allinone.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Comment {
  private String postId;
  private String id;
  private String name;
  private String email;
  private String body;
  
}
