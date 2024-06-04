package com.bootcamp.democa.controller;

import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface DatabaseOperation {
  @GetMapping(value = "/getvalue")
  
 String getValue(@RequestParam(value = "a") String a);

  @GetMapping("/database/sorting")

  void sort();

  @GetMapping("/database2")
  
  HashMap<String, String> add(@RequestParam(value = "a") String a,
      @RequestParam(value = "b") String b);

}
