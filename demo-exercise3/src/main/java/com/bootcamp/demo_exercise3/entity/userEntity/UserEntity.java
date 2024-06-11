package com.bootcamp.demo_exercise3.entity.userEntity;

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

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder

public class UserEntity {
  @Id // Table Primary Key
  @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto increment
  private Long id;
  private String name;
  @Column(name = "user_name")
  private String username;
  @Setter
  private String email;
  private String phone;
  private String website;
  @Column(name = "addr_street")
  private String addrStreet;
  @Column(name = "addr_suite")
  private String addrSuite;
  @Column(name = "addr_city")
  private String addrCity;
  @Column(name = "addr_zipcode")
  private String addrZipcode;
  @Column(name = "addr_lat")
  private String addrLat;
  @Column(name = "addr_long")
  private String addrLong;
  @Column(name = "company_name")
  private String companyName;
  @Column(name = "company_catch_phrase")
  private String companyCatchPhrase;
  @Column(name = "company_bs")
  private String companyBS;
  
}
