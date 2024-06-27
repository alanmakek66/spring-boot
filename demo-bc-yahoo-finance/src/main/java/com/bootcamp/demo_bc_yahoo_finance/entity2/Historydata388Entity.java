package com.bootcamp.demo_bc_yahoo_finance.entity2;

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
@Table(name = "History388")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Historydata388Entity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String timestamp;
  private String open;
  private String high;
  private String low;
  private String close;
  private String volume;

  
}
