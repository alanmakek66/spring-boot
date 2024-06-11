package com.bootcamp.demo_exercise3b.config;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.bootcamp.demo_exercise3b.entity.AlbumEntity;
import com.bootcamp.demo_exercise3b.entity.PhotoEntity;
import com.bootcamp.demo_exercise3b.entity.mapper.AblumEntityMapper;
import com.bootcamp.demo_exercise3b.entity.mapper.PhotoEntityMapper;
import com.bootcamp.demo_exercise3b.model.Ablum;
import com.bootcamp.demo_exercise3b.model.Photo;

import com.bootcamp.demo_exercise3b.repository.AblumRepository;
import com.bootcamp.demo_exercise3b.repository.PhotoRepository;
import com.bootcamp.demo_exercise3b.service.AblumService;
import com.bootcamp.demo_exercise3b.service.PhotoService;

@Component
public class AppRunner  implements CommandLineRunner{

  @Autowired
  private AblumRepository ablumRepository;
  @Autowired
  private PhotoRepository photoRepository;

  @Autowired
  private AblumService ablumService;
  @Autowired
  private PhotoService photoService;

  @Autowired
  private AblumEntityMapper ablumEntityMapper;
  @Autowired
  private PhotoEntityMapper photoEntityMapper;

  @Override
  public void run(String... args){
    List<Ablum> ablums=ablumService.getAblum();
    List<Photo> photos=photoService.getPhoto();

    List<AlbumEntity> albumEntities=ablums.stream()
    .map(e->ablumEntityMapper.mapAlbumEntity(e)).collect(Collectors.toList());

    List<PhotoEntity> photoEntities=photoEntityMapper.map(albumEntities, photos);

   ablumRepository.saveAll(albumEntities);

    photoRepository.saveAll(photoEntities);

}
  
}
