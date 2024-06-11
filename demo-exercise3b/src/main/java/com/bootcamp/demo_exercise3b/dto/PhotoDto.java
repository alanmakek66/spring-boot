package com.bootcamp.demo_exercise3b.dto;

import java.util.List;

import com.bootcamp.demo_exercise3b.entity.AlbumEntity;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class PhotoDto {
  private Long id;
  private String title;
  private String url;
  
}
