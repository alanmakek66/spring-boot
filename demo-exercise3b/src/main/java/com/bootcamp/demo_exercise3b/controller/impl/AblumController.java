package com.bootcamp.demo_exercise3b.controller.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.demo_exercise3b.controller.AblumOperation;
import com.bootcamp.demo_exercise3b.dto.AblumDto;
import com.bootcamp.demo_exercise3b.dto.PhotoDtoForChange;
import com.bootcamp.demo_exercise3b.dto.mapper.AblumDtoMapper;
import com.bootcamp.demo_exercise3b.dto.mapper.PhotoDtoForChangeMapper;
import com.bootcamp.demo_exercise3b.entity.AlbumEntity;
import com.bootcamp.demo_exercise3b.entity.PhotoEntity;
import com.bootcamp.demo_exercise3b.service.AblumService;
import com.bootcamp.demo_exercise3b.service.PhotoService;



@RestController
public class AblumController implements AblumOperation {
  @Autowired
  private AblumService ablumService;
  @Autowired
  private PhotoService photoService;
  @Autowired
  private PhotoDtoForChangeMapper photoDtoForChangeMapper;
  @Autowired
  private AblumDtoMapper ablumDtoMapper;
  @Autowired
  @Lazy
  private AblumController ablumController;

  @Override
  public List<AblumDto> ablumDtos(){
    List<AlbumEntity> albumEntities=ablumService.getAblumentity();
    List<PhotoEntity> photoEntities=photoService.getPhotoEntity();

    List<PhotoDtoForChange> photoDtoForChanges=photoEntities.stream()
    .map(e->photoDtoForChangeMapper.map(e)).collect(Collectors.toList());

    return ablumDtoMapper.map(albumEntities, photoDtoForChanges);



  }
  
}
