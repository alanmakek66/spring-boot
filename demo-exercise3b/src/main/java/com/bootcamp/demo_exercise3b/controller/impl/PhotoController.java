package com.bootcamp.demo_exercise3b.controller.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.demo_exercise3b.controller.PhotoOperation;
import com.bootcamp.demo_exercise3b.dto.PhotoDtoForChange;
import com.bootcamp.demo_exercise3b.dto.mapper.PhotoDtoForChangeMapper;
import com.bootcamp.demo_exercise3b.service.PhotoService;

@RestController

public class PhotoController implements PhotoOperation{
  @Autowired
  private PhotoService photoService;
  @Autowired
  private PhotoDtoForChangeMapper photoDtoForChangeMapper;

  @Override
  public List<PhotoDtoForChange> getallphoto(){
    return photoService.getPhotoEntity().stream()
    .map(e->photoDtoForChangeMapper.map(e)).collect(Collectors.toList());
    

  }
  
}
