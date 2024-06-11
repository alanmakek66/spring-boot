package com.bootcamp.demo_abph.ablumAndphotoEntityMapper;

import java.util.List;

import com.bootcamp.demo_abph.dto.PhotoDto;
import com.bootcamp.demo_abph.photoEntity.PhotoEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class AblumandPhotoEntity {
  private String userId;
  private String id;
  private String title;
  private List<PhotoEntity> photoEntities;
  
}
