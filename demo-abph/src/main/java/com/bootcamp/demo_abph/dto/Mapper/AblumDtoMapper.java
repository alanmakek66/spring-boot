package com.bootcamp.demo_abph.dto.Mapper;

import org.springframework.stereotype.Component;

import com.bootcamp.demo_abph.ablumEntity.AblumEntity;
import com.bootcamp.demo_abph.dto.AblumDto;

@Component
public class AblumDtoMapper {
  public AblumDto map(AblumEntity a1){
    return AblumDto.builder()
    .id(a1.getId())
    .userId(a1.getUserId())
    .title(a1.getTitle())
    .build();
  }
  
}
