package com.bootcamp.demo_bc_yahoo_finance.entity;







import jakarta.persistence.Column;
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



@Table(name = "stocks")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
public class StocksEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  
  private Long id;
 
  @Column(unique = true)
  private String symbol;

  public StocksEntity(String symbol ){
    this.symbol=symbol;
  }
  
}
