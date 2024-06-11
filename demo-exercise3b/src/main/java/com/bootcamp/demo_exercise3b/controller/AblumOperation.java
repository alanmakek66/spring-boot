package com.bootcamp.demo_exercise3b.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bootcamp.demo_exercise3b.dto.AblumDto;

public interface AblumOperation {

  @GetMapping(value = "/get/ablum")
  List<AblumDto> ablumDtos();

 /*  @GetMapping(value = "/get/ablum/id")
  AblumDto getablumByid(@RequestParam String id); */
  
}
