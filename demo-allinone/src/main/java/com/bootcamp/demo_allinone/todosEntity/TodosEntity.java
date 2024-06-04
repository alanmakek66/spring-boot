package com.bootcamp.demo_allinone.todosEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "todes")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class TodosEntity {
  private  String userId;
  @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String title;
  private String completed;

  
}
