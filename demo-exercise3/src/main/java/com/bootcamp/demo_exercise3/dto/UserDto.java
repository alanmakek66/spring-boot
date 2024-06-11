package com.bootcamp.demo_exercise3.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
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
public class UserDto {
  private Long id;
  private String name;
  private String username;
  private String email;
  private AddressDto addressdto;
  private String phone;
  private String website;
  private CompanyDto company;
  @JsonProperty(value ="posts")
  private List<PostandCommentDto> PostAndCommentDto;
  
  
}
