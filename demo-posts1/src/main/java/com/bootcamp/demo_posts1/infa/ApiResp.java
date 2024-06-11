package com.bootcamp.demo_posts1.infa;


import java.util.List;

import org.springframework.stereotype.Component;




import io.micrometer.common.lang.NonNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Component
@Setter
@NoArgsConstructor
@Builder
@Getter
@AllArgsConstructor
public class ApiResp<T> {

  private int code;
  private String message;
  private List<T>  data;

  public int getCode() {
    return this.code;
  }

  public String getMessage() {
    return this.message;
  }

  public List<T>  getdata() {
    return this.data;
  }

  public ApiResp(ApiRespBuilder<T> builder) {
    this.code = builder.code;
    this.message = builder.message;
    this.data = builder.data;
  }

  public String toString(){
    return "ApiResp(" +"code="+this.getCode()+", message"+ this.getMessage()
    +", data="+String.valueOf(this.getdata());
  }

  public static <U> ApiRespBuilder<U> builder() {
    return new ApiRespBuilder<>();
  }

  public static class ApiRespBuilder<T> {
    private int code;
    private String message;
    private List<T>  data;

    public ApiRespBuilder<T> code(int code) {
      this.code = code;
      return this;
    }

    public ApiRespBuilder<T> message(@NonNull  String message) throws NullPointerException  {
      if(message==null)
      throw new NullPointerException();
      this.message=message;
      return this;
    }

    public ApiRespBuilder<T> ok() {
      this.code = 0;
      this.message = "Success.";
      return this;
    }
    public ApiRespBuilder<T> notfound() {
      this.code = 99;
      this.message = "not found.";
      return this;
    }

    

    // public ApiRespBuilder<T> badRequest() {
    // this.code = 99;
    // this.message = "Bad Request.";
    // return this;
    // }

    public ApiRespBuilder<T> data(List<T>  data) {
      this.data = data;
      return this;
    }

    public ApiResp<T> build() {
      return new ApiResp<>(this);
    }
  }

  


  }

