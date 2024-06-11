package com.bootcamp.demo_abph.dto.Mapper;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.hibernate.annotations.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bootcamp.demo_abph.ablumAndphotoEntityMapper.AblumandPhotoEntity;
import com.bootcamp.demo_abph.dto.AblumAndPhotoDto;
import com.bootcamp.demo_abph.dto.PhotoDto;

@Component
public class AblumAndPhotoDtoMapper {

  @Autowired
  private PhotoDtoMapper photoDtoMapper;

  public AblumAndPhotoDto map(AblumandPhotoEntity ablumandPhotoEntity){
    List<PhotoDto> test1=ablumandPhotoEntity.getPhotoEntities()
    .stream().map(e->photoDtoMapper.map(e)).collect(Collectors.toList());

    return AblumAndPhotoDto.builder()
    .id(ablumandPhotoEntity.getId())
    .title(ablumandPhotoEntity.getTitle())
    .photoDtos(test1)
    .build();
  }
  
}
