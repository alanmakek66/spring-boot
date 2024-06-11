package com.bootcamp.demo_exercise3.entity.postEntity;

import java.io.Serializable;
import org.hibernate.annotations.ManyToAny;

import com.bootcamp.demo_exercise3.entity.userEntity.UserEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Posts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class PostEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String title;
  private String body;

  
  @ManyToOne
  @JoinColumn(name = "user_id")  // DB table column name (Foreign Key)
 
  private UserEntity userEntity; // object
  
}
