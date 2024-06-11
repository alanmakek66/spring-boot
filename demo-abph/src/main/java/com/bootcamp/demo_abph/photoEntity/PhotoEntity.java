package com.bootcamp.demo_abph.photoEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Entity
@Table(name = "photo10")
public class PhotoEntity {
  private String albumId;
  @Id
  private String id;
  private String title;
  private String url;
  private String thumbnailUrl;
  
}
