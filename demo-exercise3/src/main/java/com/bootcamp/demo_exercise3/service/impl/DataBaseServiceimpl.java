package com.bootcamp.demo_exercise3.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bootcamp.demo_exercise3.model.Comment;
import com.bootcamp.demo_exercise3.model.Post;
import com.bootcamp.demo_exercise3.model.User;
import com.bootcamp.demo_exercise3.service.DataBaseService;

@Service
public class DataBaseServiceimpl implements DataBaseService {

  @Override
  public List<User> getUser(){
    String url="https://jsonplaceholder.typicode.com/users";
    User[] users=new RestTemplate().getForObject(url, User[].class);
    return Arrays.asList(users);
  }

  @Override
  public List<Post> getPost(){
    String url="https://jsonplaceholder.typicode.com/posts";
    Post[] posts=new RestTemplate().getForObject(url, Post[].class);
    return  Arrays.asList(posts);
  }
  @Override
  public List<Comment> getComment(){
    String url="https://jsonplaceholder.typicode.com/comments";
    Comment[] comments=new RestTemplate().getForObject(url, Comment[].class);
    return  Arrays.asList(comments);
  }
  
}
