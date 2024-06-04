package com.bootcamp.demo_public_transportation.transportationEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "value")
@Builder
public class ValueEntity {
@Id
  private String route;
  private String orig_en;
  private String orig_tc;
  
  private String dest_en;
  private String dest_tc;
  private String operator;

 
  
}
