package com.bootcamp.demo_posts1.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.demo_posts1.controller.PostOperation;
import com.bootcamp.demo_posts1.dto.RequestDto;
import com.bootcamp.demo_posts1.infa.NotFoundException;
import com.bootcamp.demo_posts1.model.Post;
import com.bootcamp.demo_posts1.postEntity.PostEntity;
import com.bootcamp.demo_posts1.service.PostService;

@RestController
public class PostController implements PostOperation {
  @Autowired
  private PostService postService;

  @Override
  public List<Post> getpost(){
    
    return postService.getPost1();

  }

  @Override
  public List<PostEntity> getpostDB(){
    return postService.getallPost();
  }
  @Override
  public PostEntity getPostByid(String id){
    return postService.getPostById(id);
  }
  @Override
  public List<PostEntity> getPostBybodyContain(@RequestParam String body)throws NotFoundException{
    return postService.getPostBybody(body);

  }
  @Override
  public List<PostEntity> getPostBybodyLike(@RequestParam String body) throws NotFoundException{
    return postService.getPostBybodyLike(body);
  }

  @Override
  public PostEntity replacePostbyid(@RequestParam String id,@RequestBody PostEntity post1) throws NotFoundException{
    return postService.replacePostByid(id, post1);
  }

  @Override
  public PostEntity updateBodyById(@RequestParam String id,@RequestBody RequestDto dto) throws
  NotFoundException{
    return postService.replacePostByid2(id, dto);
  }
  
  
}
