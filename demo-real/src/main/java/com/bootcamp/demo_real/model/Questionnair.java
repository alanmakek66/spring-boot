package com.bootcamp.demo_real.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Questionnair {
  private List<String> options1;
    private List<String> options2;
    private List<String>options3;
    private String selectedOption1;
    private String selectedOption2;
    private String selectedOption3;
  
}
