package com.bootcamp.demo_exercise3.infa;



import java.util.List;

import org.springframework.stereotype.Component;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Component
@Setter
@NoArgsConstructor
@Builder
@Getter
@AllArgsConstructor

public class ApiResp<T> {

  private String id;
  private String message;
  private List<T> data;

  public String getid() {
    return this.id;
  }

  public String getMessage() {
    return this.message;
  }

  public List<T> getdata() {
    return this.data;
  }

  public ApiResp(ApiRespBuilder<T> builder) {
    this.id = builder.id;
    this.message = builder.message;
    this.data = builder.data;
  }
  public static <U> ApiRespBuilder<U> builder() {
    return new ApiRespBuilder<>();
  }

  public static class ApiRespBuilder<T> {
    private String id;
    private String message;
    private List<T> data;

    public ApiRespBuilder<T> id(String id) {
      this.id = id;
      return this;
    }

    public ApiRespBuilder<T> message(String message) {
      this.message = message;
      return this;
    }

    public ApiRespBuilder<T> data(List<T> data) {
      this.data = data;
      return this;
    }

    public ApiResp<T> build() {
      return new ApiResp<>(this);
    }
  }

}
