package com.bootcamp.demo_exercise3.dto;
import jakarta.persistence.Column;
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
public class CommentDto {
  private Long postId;
  private Long id;
  private String name;
  private String email;
  private String body;
  
}
