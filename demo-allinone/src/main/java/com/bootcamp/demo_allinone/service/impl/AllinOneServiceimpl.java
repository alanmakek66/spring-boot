package com.bootcamp.demo_allinone.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bootcamp.demo_allinone.CommentEntity.CommentEntity;
import com.bootcamp.demo_allinone.CommentEntity.Mapper.CommentEntityMapper;
import com.bootcamp.demo_allinone.UserEntity.UserEntity;
import com.bootcamp.demo_allinone.UserEntity.Mapper.UserEntityMapper;
import com.bootcamp.demo_allinone.ablumEntity.AblumEntity;
import com.bootcamp.demo_allinone.ablumEntity.Mapper.AblumEntityMapper;
import com.bootcamp.demo_allinone.model.Album;
import com.bootcamp.demo_allinone.model.Comment;
import com.bootcamp.demo_allinone.model.Post;
import com.bootcamp.demo_allinone.model.Todos;
import com.bootcamp.demo_allinone.model.User;
import com.bootcamp.demo_allinone.postEntity.PostEntity;
import com.bootcamp.demo_allinone.postEntity.Mapper.PostEntityMapper;
import com.bootcamp.demo_allinone.repository.AblumRepository;
import com.bootcamp.demo_allinone.repository.CommentRepositry;
import com.bootcamp.demo_allinone.repository.PostRepository;
import com.bootcamp.demo_allinone.repository.TodosRepository;
import com.bootcamp.demo_allinone.repository.UserRepository;
import com.bootcamp.demo_allinone.service.AllinOneService;
import com.bootcamp.demo_allinone.todosEntity.TodosEntity;
import com.bootcamp.demo_allinone.todosEntity.Mapper.TodosEntityMapper;

@Service
public class AllinOneServiceimpl implements AllinOneService {

  @Autowired
  private UserRepository userRepository;
  @Autowired 
  private AblumRepository ablumRepository;
  @Autowired
  private PostRepository postRepository;
  @Autowired
  private TodosRepository todosRepository;
  @Autowired
  private CommentRepositry commentRepositry;


  @Autowired
  private UserEntityMapper uem1;
  @Autowired
  private AblumEntityMapper aem1;
  @Autowired
  private PostEntityMapper pem1;
  @Autowired
  private TodosEntityMapper tem1;
  @Autowired
  private CommentEntityMapper cem1;


  @Override
  public List<User> getUsers(){
    String url= "https://jsonplaceholder.typicode.com/users";

    User[] u1=new RestTemplate().getForObject(url, User[].class);

    return Arrays.asList(u1);


  }

  @Override 
  public List<UserEntity> getUsersAndSave(){
    String url= "https://jsonplaceholder.typicode.com/users";

    User[] u1=new RestTemplate().getForObject(url, User[].class);

     
     List<User> list1 = Arrays.asList(u1);
     List<UserEntity> list2=list1.stream().map(e->uem1.map(e)).collect(Collectors.toList());

    
     userRepository.saveAll(list2);

     return list2;

    
    
  }
  @Override
  public List<AblumEntity> getAblumAndSave(){
    String url= "https://jsonplaceholder.typicode.com/albums";

    Album[] u1=new RestTemplate().getForObject(url, Album[].class);

    List<Album> list1 = Arrays.asList(u1);
     List<AblumEntity> list2=list1.stream().map(e->aem1.map(e)).collect(Collectors.toList());
     ablumRepository.saveAll(list2);

     return list2;

  }
  @Override
  public List<PostEntity> getPostAndSave(){
    String url= "https://jsonplaceholder.typicode.com/posts";

    Post[] u1=new RestTemplate().getForObject(url, Post[].class);

    List<Post> list1 = Arrays.asList(u1);
     List<PostEntity> list2=list1.stream().map(e->pem1.map(e)).collect(Collectors.toList());
     postRepository.saveAll(list2);

     return list2;

  }
  @Override
  public List<TodosEntity> getTodosAndSave(){
    String url= "https://jsonplaceholder.typicode.com/todos";

    Todos[] u1=new RestTemplate().getForObject(url, Todos[].class);

    List<Todos> list1 = Arrays.asList(u1);
     List<TodosEntity> list2=list1.stream().map(e->tem1.map(e)).collect(Collectors.toList());
     todosRepository.saveAll(list2);

     return list2;

  }
  @Override
  public List<CommentEntity> getCommentAndSave(){
    String url= "https://jsonplaceholder.typicode.com/todos";

    Comment[] u1=new RestTemplate().getForObject(url, Comment[].class);

    List<Comment> list1 = Arrays.asList(u1);
     List<CommentEntity> list2=list1.stream().map(e->cem1.map(e)).collect(Collectors.toList());
     commentRepositry.saveAll(list2);

     return list2;

  }
  
}
