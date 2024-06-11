package com.bootcamp.demo_exercise3b.dto.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.stereotype.Component;

import com.bootcamp.demo_exercise3b.dto.AblumDto;
import com.bootcamp.demo_exercise3b.dto.PhotoDto;
import com.bootcamp.demo_exercise3b.dto.PhotoDtoForChange;
import com.bootcamp.demo_exercise3b.entity.AlbumEntity;



@Component
public class AblumDtoMapper {
  @Autowired
  private PhotoDtoForChangeMapper photoDtoForChangeMapper;
  @Autowired
  private PhotoDtoMapper photoDtoMapper;


  public List<AblumDto> map(List<AlbumEntity> albumEntities
  ,List<PhotoDtoForChange> photoDtoForChanges){
    return albumEntities.stream().map(ablum->{
      List<PhotoDtoForChange> list1=photoDtoForChanges.stream()
      .filter(photo->photo.getAblumid().equals(ablum.getId().toString())).collect(Collectors.toList());

      List<PhotoDto> photoDtos=list1.stream()
      .map(e->photoDtoMapper.map(e)).collect(Collectors.toList());

      return AblumDto.builder()
      .id(ablum.getId())
      .title(ablum.getTitle())
      .userId(ablum.getUserId())
      .photoDtos(photoDtos)
      .build();



    }).collect(Collectors.toList());

  }

  
}
