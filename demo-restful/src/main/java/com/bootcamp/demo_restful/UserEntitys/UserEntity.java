package com.bootcamp.demo_restful.UserEntitys;

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
@Table(name="Users")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class UserEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String username;
  private String email;
  private String website;
  private String addrStreet;
  private String addrSuite;
  private String addrcity;
  private String addrzipcode;
  private String addrLat;
  private String addrLong;
  private String companyName;
  private String companycatchPhrase;
  private String companyBs;
  private String phone;
  
  
}
