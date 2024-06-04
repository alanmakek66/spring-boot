package com.bootcamp.demo_posts1.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bootcamp.demo_posts1.dto.RequestDto;
import com.bootcamp.demo_posts1.infa.NotFoundException;
import com.bootcamp.demo_posts1.model.Post;
import com.bootcamp.demo_posts1.postEntity.PostEntity;
import com.bootcamp.demo_posts1.postEntity.Mapper.PostEntityMapper;
import com.bootcamp.demo_posts1.repository.PostRepository;
import com.bootcamp.demo_posts1.service.PostService;

@Service
public class PostServiceimpl implements PostService {

  @Autowired
  private PostRepository postRepository;

  @Autowired 
  private PostEntityMapper pem1;


  @Override
  public List<Post> getPost1(){
    String url="https://jsonplaceholder.typicode.com/posts";
    Post[] list1 = new RestTemplate().getForObject(url, Post[].class);

     postRepository.saveAll(Arrays.asList(list1).stream().map(e->pem1.map(e))
    .collect(Collectors.toList())); 
    
    return Arrays.asList(list1);

  }
  @Override
  public List<PostEntity> getallPost(){
    List<PostEntity> test1 =postRepository.findAll();
    
    return test1;

  }
  @Override
  public PostEntity getPostById(String id) throws NotFoundException{
    return postRepository.findById(id).orElseThrow(()->new NotFoundException());
  }

  @Override
  public  List<PostEntity> getPostBybody(String body) throws NotFoundException{
    return postRepository.findByBodyContaining(body).orElseThrow(()->new NotFoundException());
  }
  @Override
  public List<PostEntity> getPostBybodyLike(String body) throws NotFoundException{
    return postRepository.findByBodyLike(body).orElseThrow(()->new NotFoundException());
  }
  @Override
  public PostEntity replacePostByid(String id,PostEntity post1) throws NotFoundException{
    Optional<PostEntity> test1 =postRepository.findById(id);
    if(test1.isPresent()&&post1.getId().equals(id)){
      postRepository.save(post1);
      return post1;
} throw new NotFoundException();
  }

  @Override
  public PostEntity replacePostByid2(String id,RequestDto dto) throws NotFoundException{
    Optional<PostEntity> test1 =postRepository.findById(id);
    if(test1.isPresent()){
      PostEntity test2=test1.get();
      test2.setBody(dto.getBody());
      postRepository.save(test2);
      return test2;

  } throw new NotFoundException();
  
}

}
