package com.bootcamp.demo_abph.controller.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.demo_abph.controller.TwoInOneOperation;
import com.bootcamp.demo_abph.dto.AblumAndPhotoDto;
import com.bootcamp.demo_abph.dto.AblumDto;
import com.bootcamp.demo_abph.dto.PhotoDto;
import com.bootcamp.demo_abph.dto.Mapper.AblumAndPhotoDtoMapper;
import com.bootcamp.demo_abph.dto.Mapper.AblumDtoMapper;
import com.bootcamp.demo_abph.dto.Mapper.PhotoDtoMapper;
import com.bootcamp.demo_abph.photoEntity.PhotoEntity;
import com.bootcamp.demo_abph.service.TwoInOneService;
import com.bootcamp.demo_abph.service.impl.TwoInOneServiceimpl;

@RestController
public class TwoInOneController implements TwoInOneOperation {
  @Autowired
  private TwoInOneService twoInOneService;
  @Autowired
  private AblumDtoMapper ablumDtoMapper;
  @Autowired
  private PhotoDtoMapper photoDtoMapper;
  @Autowired
  private AblumAndPhotoDtoMapper ablumAndPhotoDtoMapper;

  @Override
  public List<AblumDto> pushAblum(){
    List<AblumDto> ablumDtos=
    twoInOneService.pushAblumtoDB().stream().map(e->ablumDtoMapper.map(e))
.collect(Collectors.toList());

    return ablumDtos;

  }

  @Override
  public List<PhotoDto> pushPhoto(){
    List<PhotoDto> photoDtos=
    twoInOneService.pushPhototoDB()
    .stream().map(e->photoDtoMapper.map(e)).collect(Collectors.toList());

    return photoDtos;
  }
  @Override
  public List<AblumDto> getAblum(){
    return twoInOneService.getAblumtoDB().stream().map(e->ablumDtoMapper.map(e))
    .collect(Collectors.toList());
  }
  @Override
  public List<PhotoDto> getPhoto(){
    return twoInOneService.getPhototoDB().stream().map(e->photoDtoMapper.map(e))
    .collect(Collectors.toList());
  }
  @Override
  public List<AblumAndPhotoDto> getAblumAndPhotoDto(){
    return twoInOneService.getAblumandPhotoEntities().stream()
    .map(e->ablumAndPhotoDtoMapper.map(e)).collect(Collectors.toList());
  }
  @Override
  public List<AblumDto> geAblumByUserId(String userid){
    return twoInOneService.findByUserId(userid).stream()
    .map(e-> ablumDtoMapper.map(e)).collect(Collectors.toList());


  }
  @Override
  public List<PhotoDto> findBytitle(@RequestParam String title){
    return twoInOneService.findBytitle(title).stream().map(e->photoDtoMapper.map(e))
    .collect(Collectors.toList());
  }
}
