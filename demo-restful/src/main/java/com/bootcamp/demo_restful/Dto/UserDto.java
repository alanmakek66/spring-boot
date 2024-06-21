package com.bootcamp.demo_restful.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Builder

public class UserDto {
  


  private String id;
  private String name;
  //private String username;
  //private String email;
  //private Addressdto address;
  //private String phone;
  //private String website;
  private Companydto company;

  @Setter
  @Getter
  @Builder
  public static class Addressdto {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Location geo;

    @Setter
    @Getter
    public static class Location {
      private String lat;
      private String lng;
    }

  }

  @Setter
  @Getter
  @Builder
  public static class Companydto {
    private String name;
    private String catchPhrase;
    //@JsonProperty(value = "bs") 
    private String business;

  }
  
}
