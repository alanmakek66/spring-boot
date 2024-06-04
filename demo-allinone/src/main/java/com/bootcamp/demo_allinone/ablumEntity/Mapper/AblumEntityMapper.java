package com.bootcamp.demo_allinone.ablumEntity.Mapper;

import org.springframework.stereotype.Component;

import com.bootcamp.demo_allinone.ablumEntity.AblumEntity;
import com.bootcamp.demo_allinone.model.Album;

@Component
public class AblumEntityMapper {

  public AblumEntity map(Album a1 ){
    return AblumEntity.builder()
    .userId(a1.getUserId())
    .id(a1.getId())
    .title(a1.getTitle())
    .build();

  }
  
}
