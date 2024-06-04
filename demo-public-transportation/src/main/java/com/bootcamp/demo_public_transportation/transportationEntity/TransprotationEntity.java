package com.bootcamp.demo_public_transportation.transportationEntity;



import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder

public class TransprotationEntity {
  @Id
  private String route;
  private String orig_en;
  private String orig_tc;
  
  private String dest_en;
  private String dest_tc;
  private String operator;
  
  
  
  
}
