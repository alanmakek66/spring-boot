package com.bootcamp.democa.controller;

import org.springframework.web.bind.annotation.GetMapping;

import com.bootcamp.democa.model.Cat;

public interface TestOperation {
  @GetMapping(value = "/hello")
  String testSayhello();

  @GetMapping(value = "/hello2")
  String testSayhello2();

  @GetMapping(value = "/hello3")
  String testSayhello3();

  @GetMapping(value = "/getWhitecat")
  Cat getWhiteCat();

  @GetMapping(value = "/cat2")
  Cat getcat2();

}
