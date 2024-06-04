package com.bootcamp.demo_bus.infa;

import java.util.List;

import com.bootcamp.demo_bus.dto.KmbRouteDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ApiResp<T> {
  private int code;
  private String message;
  private List<T> data;

  public ApiResp(ApiRespBuilder a1) {
    this.code = a1.code;
    this.message = a1.message;
    this.data = a1.data;
  }

  public int getCode() {
    return this.code;
  }

  public String getMessage() {
    return this.message;
  }

  public List<T> getData() {
    return this.data;
  }

 

  public static <T> ApiRespBuilder builder(){
    return new ApiRespBuilder<>();

  }

  public static class ApiRespBuilder<T> {
    private int code;
    private String message;
    private List<T> data;

    public ApiRespBuilder code(int code) {
      this.code = code;
      return this;
    }

    public ApiRespBuilder message(String message) {
      this.message = message;
      return this;
    }

    public ApiRespBuilder data(List<T> data) {
      this.data = data;
      return this;
    }

    public ApiResp build() {
      return new ApiResp(this);
    }

    public ApiRespBuilder<T> ok(){
      this.code=0;
      this.message="Success.";
      return this;
    }

    public ApiRespBuilder<T> badrequest(){
      this.code=99;
      this.message="Bad request.";
      return this;
    }
  }

  public static void main(String[] args) throws JsonProcessingException {
    ApiResp<KmbRouteDto> response= ApiResp.<KmbRouteDto>builder()
    .ok().data(List.of(new KmbRouteDto()))
    .build();
// Object -> json 
    ObjectMapper objectMapper = new ObjectMapper();

    String jsonString=objectMapper.writeValueAsString(response);
    System.out.println(jsonString);

    /* try{
      TypeReference<ApiResp<KmbRouteDto>>
    } */
    
  }

}
