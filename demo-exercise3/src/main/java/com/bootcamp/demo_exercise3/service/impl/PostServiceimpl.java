package com.bootcamp.demo_exercise3.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.bootcamp.demo_exercise3.dto.mapper.PostandCommentEntityMapper;
import com.bootcamp.demo_exercise3.entity.postEntity.PostAndCommnetEntity;
import com.bootcamp.demo_exercise3.entity.postEntity.PostEntity;
import com.bootcamp.demo_exercise3.entity.userEntity.UserEntity;
import com.bootcamp.demo_exercise3.infa.NotFoundException;
import com.bootcamp.demo_exercise3.repository.CommentRepository;
import com.bootcamp.demo_exercise3.repository.PostRepository;
import com.bootcamp.demo_exercise3.repository.UserRepository;
import com.bootcamp.demo_exercise3.service.PostService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PostServiceimpl implements PostService {
@Autowired
private PostRepository postRepository;

@Autowired 
@Lazy
private PostService postService;
@Autowired
private CommentRepository commentRepository;
@Autowired
private PostandCommentEntityMapper postandCommentEntityMapper;
@Autowired
private UserRepository userRepository;

  @Override
  public List<PostEntity> getPostEntity(){
    return postRepository.findAll();


   }
   @Override
   public List<PostAndCommnetEntity> getPostAndCommnetEntities(){

    return
    postandCommentEntityMapper.map(postRepository.findAll(), commentRepository.findAll());
    
 }
 @Override
 public PostAndCommnetEntity getPostByid(String id){

  try{
    Long iid=Long.valueOf(id);
}catch(NumberFormatException n){
    throw new NumberFormatException();
  }
  Long iid=Long.valueOf(id);

 return postService.getPostAndCommnetEntities().stream()
 .filter(e->e.getUserEntity().getId().equals(iid))
 .findFirst().orElseThrow(()->new NotFoundException());

 }
 @Override
 public PostEntity addPostByuserId( String id,PostEntity postEntity){
  try{
    Long iid=Long.valueOf(id);
}catch(NumberFormatException n){
    throw new NumberFormatException();
  }
  Long iid=Long.valueOf(id);

  UserEntity test1 =userRepository.findById(iid)
  .orElseThrow(()->new NotFoundException());
 
  postRepository.save(postEntity);

  return postEntity;
 }
 
 @Override
 public PostEntity deletePostByid(String id){
  try{
    Long iid=Long.valueOf(id);
}catch(NumberFormatException n){
    throw new NumberFormatException();
  }
  Long iid=Long.valueOf(id);
  commentRepository.findById(iid).orElseThrow(()->new NotFoundException());

  commentRepository.deleteByPostEntityId(iid);
  
  PostEntity copy=postRepository.getById(iid);
  postRepository.deleteById(iid);
  return copy;

 }
  
}
