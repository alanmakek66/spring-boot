package com.bootcamp.demo_allinone.ablumEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Ablum")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AblumEntity {
  private String userId;
  @Id
  private String id;
  private String title;
  
}
