package com.bootcamp.demo_abph.ablumEntity.mapper;

import org.springframework.stereotype.Component;

import com.bootcamp.demo_abph.ablumEntity.AblumEntity;
import com.bootcamp.demo_abph.dto.AblumDto;
import com.bootcamp.demo_abph.model.Ablum;

@Component
public class AblumEntityMapper {
  public AblumEntity map(Ablum a1){
    return AblumEntity.builder()
    .id(a1.getId())
    .userId(a1.getUserId())
    .title(a1.getTitle())
    .build();

  }
  
}
