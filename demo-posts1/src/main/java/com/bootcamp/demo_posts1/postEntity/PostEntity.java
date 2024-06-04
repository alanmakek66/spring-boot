package com.bootcamp.demo_posts1.postEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="postTest")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class PostEntity {
  private String userId;
  @Id
  private String id;
  @Column(name = ("body"))
  private String body;
  
}
