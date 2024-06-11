package com.bootcamp.demo_exercise3.dto;
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
public class CompanyDto {
  @JsonProperty(value = "company_name")
  private String name;
    private String catchPhrase;
    @JsonProperty(value = "business")
    private String business;
  
  
}
