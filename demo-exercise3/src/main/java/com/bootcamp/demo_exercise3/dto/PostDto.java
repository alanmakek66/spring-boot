package com.bootcamp.demo_exercise3.dto;

import java.util.List;

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
public class PostDto {
  //private Long userId;
  private Long id;
  private String title;
  private String body;
  private List<CommentDto> commentDtos;
  
}
