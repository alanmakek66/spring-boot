package com.bootcamp.demo_exercise3.model;
import com.fasterxml.jackson.annotation.JsonProperty;

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
public class User {
  private Long id;
  private String name;
  private String username;
  private String email;
  private Address address;
  private String phone;
  private String website;
  private Company company;

  @Getter
  @Builder
  @AllArgsConstructor
  @NoArgsConstructor
  @Setter
  public static class Address {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Location geo;

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Setter
    public static class Location {
      private String lat;
      private String lng;
    }

  }

  @Getter
  @Builder
  @AllArgsConstructor
  @NoArgsConstructor
  @Setter
  public static class Company {
    private String name;
    private String catchPhrase;
    @JsonProperty(value = "bs")
    private String business;

  }
  
}
