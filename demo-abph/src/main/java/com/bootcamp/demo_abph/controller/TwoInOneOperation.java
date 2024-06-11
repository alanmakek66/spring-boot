package com.bootcamp.demo_abph.controller;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bootcamp.demo_abph.ablumAndphotoEntityMapper.AblumandPhotoEntity;
import com.bootcamp.demo_abph.dto.AblumAndPhotoDto;
import com.bootcamp.demo_abph.dto.AblumDto;
import com.bootcamp.demo_abph.dto.PhotoDto;
import com.bootcamp.demo_abph.photoEntity.PhotoEntity;

public interface TwoInOneOperation {

  @GetMapping(value = "/push/ablum/db")
  List<AblumDto> pushAblum();
  @GetMapping(value = "/push/photo/db")
  List<PhotoDto> pushPhoto();

  @GetMapping(value = "/get/ablum/db")
  List<AblumDto> getAblum();
  @GetMapping(value = "/get/photo/db")
  List<PhotoDto> getPhoto();

  @GetMapping(value = "/get/ablum/with/photo")
  List<AblumAndPhotoDto> getAblumAndPhotoDto();

  @GetMapping(value = "/get/ablum/userid")
  List<AblumDto> geAblumByUserId(@RequestParam String userid);

  @GetMapping(value = "/get/photo/title")
  List<PhotoDto> findBytitle(@RequestParam String title);
  
}
