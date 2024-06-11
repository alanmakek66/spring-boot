package com.bootcamp.demo_exercise3.entity.commentEntity.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.Mapping;

import com.bootcamp.demo_exercise3.entity.commentEntity.CommentEntity;
import com.bootcamp.demo_exercise3.entity.postEntity.PostEntity;
import com.bootcamp.demo_exercise3.entity.userEntity.UserEntity;
import com.bootcamp.demo_exercise3.model.Comment;
import com.bootcamp.demo_exercise3.model.Post;

@Component

public class CommentEntityMapper {
   public List<CommentEntity> map(List<PostEntity> p1,List<Comment>c1){
List<CommentEntity> list1= new ArrayList<>();

    for(int i=0;i<c1.size();i++){
      for(int k=0;k<p1.size();k++){
        if(c1.get(i).getPostId()==p1.get(k).getId()){
          
          list1.add(CommentEntity.builder()
          .id(c1.get(i).getId())
          .body(c1.get(i).getBody())
          .email(c1.get(i).getEmail())
          .name(c1.get(i).getName())
          .postEntity(p1.get(k))
          .build()) ;
        }
      }
    }return list1;
}

  
  
}
