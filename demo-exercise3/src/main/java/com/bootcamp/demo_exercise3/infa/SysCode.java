package com.bootcamp.demo_exercise3.infa;
import lombok.Getter;

@Getter
public enum SysCode {
  OK(0, "success."), //
  NOT_FOUND(1, "not found."), //
  USER_ID_NOT_FOUND(2, "User ID not found."), //
  API_ERROR(3, "API ERROR"), //
  ;

  private int code;
  private String desc;

  private SysCode(int code, String desc) {
    this.code = code;
    this.desc = desc;
  }
}
