package com.bootcamp.demo_exercise3.dto;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AddressDto {
  private String street;
    private String suite;
    private String city;
    private String zipcode;
    @JsonProperty(value ="location")
    private LocationDto geo;
  
}
