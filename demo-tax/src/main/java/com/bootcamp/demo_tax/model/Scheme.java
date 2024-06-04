package com.bootcamp.demo_tax.model;

import lombok.Getter;

@Getter
public enum Scheme {
  HTTPS("https"), //
  HTTP("http"), //
  ;

  private String value;

  private Scheme(String value) {
    this.value = value;
  }

  public String lowercase() {
    return this.value.toLowerCase();
  }

}
