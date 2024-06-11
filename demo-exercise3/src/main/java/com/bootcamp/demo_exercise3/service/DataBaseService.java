package com.bootcamp.demo_exercise3.service;

import java.util.List;

import com.bootcamp.demo_exercise3.model.Comment;
import com.bootcamp.demo_exercise3.model.Post;
import com.bootcamp.demo_exercise3.model.User;

public interface DataBaseService {
  List<User> getUser();
  List<Post> getPost();
  List<Comment> getComment();
  
  
  
}
