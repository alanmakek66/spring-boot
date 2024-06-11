package com.bootcamp.demo_exercise3b.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
@Entity
@Table(name = "photo")
public class PhotoEntity {
  @ManyToOne
  @JoinColumn(name = "album_id")
  private AlbumEntity albumEntity;
  @Id
  private Long id;
  private String title;
  private String url;
  
}
