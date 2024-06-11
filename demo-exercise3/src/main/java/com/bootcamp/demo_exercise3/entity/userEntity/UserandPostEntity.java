package com.bootcamp.demo_exercise3.entity.userEntity;

import java.util.List;

import com.bootcamp.demo_exercise3.entity.postEntity.PostAndCommnetEntity;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class UserandPostEntity {
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
  private List<PostAndCommnetEntity> postAndCommnetEntities;
  
}
