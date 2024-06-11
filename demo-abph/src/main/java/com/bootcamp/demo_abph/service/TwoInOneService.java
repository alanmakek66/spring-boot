package com.bootcamp.demo_abph.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;

import com.bootcamp.demo_abph.ablumAndphotoEntityMapper.AblumandPhotoEntity;
import com.bootcamp.demo_abph.ablumEntity.AblumEntity;
import com.bootcamp.demo_abph.photoEntity.PhotoEntity;

public interface TwoInOneService {

  List<AblumEntity> pushAblumtoDB();
  List<PhotoEntity> pushPhototoDB();

  List<AblumEntity> getAblumtoDB();
  List<PhotoEntity> getPhototoDB();

  List<AblumandPhotoEntity> getAblumandPhotoEntities();

  List<AblumEntity> findByUserId(@Param("userId")String userid);

List<PhotoEntity> findBytitle(@Param("str") String str);

  

  
}
