package com.bootcamp.demo_spe1.infra;

import lombok.Getter;

@Getter
public enum Syscode {
  OK(0, "success."), //
  NOT_FOUND(1, "not found."),
  Format_Error(2, "Format_Error.")
  ;

  private int code;
  private String desc;

  private Syscode(int code, String desc) {
    this.code = code;
    this.desc = desc;
  }
}
