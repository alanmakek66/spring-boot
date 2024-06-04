package com.bootcamp.demo_allinone.UserEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Users1")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
  private String phone;
  private String addrLat;
  private String addrLong;
  private String companyName;
  private String companycatchPhrase;
  private String companyBs;
  
  
}
