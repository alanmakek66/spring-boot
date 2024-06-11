package com.bootcamp.demo_exercise3.model;
import jakarta.persistence.Column;
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
public class Comment {
  private Long postId;
  private Long id;
  private String name;
  private String email;
  private String body;
  
}
