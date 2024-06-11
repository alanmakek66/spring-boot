package com.bootcamp.demo_exercise3.entity.commentEntity;

import java.io.Serializable;
import org.hibernate.annotations.ManyToAny;

import com.bootcamp.demo_exercise3.entity.postEntity.PostEntity;
import com.bootcamp.demo_exercise3.entity.userEntity.UserEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
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
@Table(name = "Comments")
@Getter

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Setter

public class CommentEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String email;
  @Column(length = 1000)
  private String body;
  @ManyToOne
  @JoinColumn(name = "post_id") // DB table column name (Foreign Key)
  
  private PostEntity postEntity;

}
