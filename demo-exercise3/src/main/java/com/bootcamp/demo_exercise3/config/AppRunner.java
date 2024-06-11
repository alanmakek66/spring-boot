package com.bootcamp.demo_exercise3.config;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.bootcamp.demo_exercise3.entity.commentEntity.CommentEntity;
import com.bootcamp.demo_exercise3.entity.commentEntity.mapper.CommentEntityMapper;
import com.bootcamp.demo_exercise3.entity.postEntity.PostEntity;
import com.bootcamp.demo_exercise3.entity.postEntity.Mapper.PostEntityMapper;
import com.bootcamp.demo_exercise3.entity.userEntity.UserEntity;
import com.bootcamp.demo_exercise3.entity.userEntity.mapper.UserEntityMapper;
import com.bootcamp.demo_exercise3.repository.CommentRepository;
import com.bootcamp.demo_exercise3.repository.PostRepository;
import com.bootcamp.demo_exercise3.repository.UserRepository;
import com.bootcamp.demo_exercise3.service.DataBaseService;

@Component
public class AppRunner  implements CommandLineRunner {

@Autowired
private UserRepository userRepository;
@Autowired
private PostRepository postRepository;
@Autowired
private CommentRepository commentRepository;
@Autowired
private DataBaseService dataBaseService;
@Autowired
private UserEntityMapper userEntityMapper;
@Autowired
private PostEntityMapper postEntityMapper;
@Autowired
private CommentEntityMapper commentEntityMapper;

 @Override
public void run(String... args) {
  List<UserEntity> userEntities=dataBaseService.getUser()
  .stream().map(e->userEntityMapper.map(e)).collect(Collectors.toList());

 userRepository.saveAll(userEntities);

 List<PostEntity> postEntities=postEntityMapper.map(userEntities, dataBaseService.getPost());
 postRepository.saveAll(postEntities);
 //dataBaseService.getPost();
  List<CommentEntity> commentEntities= commentEntityMapper.map(postEntities, dataBaseService.getComment());
commentRepository.saveAll(commentEntities);

    
  }
 
  
}
