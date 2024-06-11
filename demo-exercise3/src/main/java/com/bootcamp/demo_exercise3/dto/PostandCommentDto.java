package com.bootcamp.demo_exercise3.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

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
public class PostandCommentDto {
   private Long userId;
  private Long id;
  private String title;
  private String body;
  @JsonProperty(value ="comment")
  private List<CommentDto> commentDtos;
  
  
}
