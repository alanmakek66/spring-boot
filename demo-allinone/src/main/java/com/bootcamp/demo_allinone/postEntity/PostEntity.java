package com.bootcamp.demo_allinone.postEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "post")
@AllArgsConstructor
@Getter
@NoArgsConstructor
@Builder
public class PostEntity {
  private String userId;
  @Id
  private String id;
  private String title;
  private String body;
  
}
