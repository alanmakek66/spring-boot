package com.bootcamp.demo_exercise3b.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

import com.bootcamp.demo_exercise3b.dto.PhotoDtoForChange;

public interface PhotoOperation {


 @GetMapping(value = "/get/photo")
  List<PhotoDtoForChange> getallphoto();
  
}
