package com.bootcamp.demo_exercise3.entity.postEntity.Mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.Mapping;

import com.bootcamp.demo_exercise3.entity.postEntity.PostEntity;
import com.bootcamp.demo_exercise3.entity.userEntity.UserEntity;
import com.bootcamp.demo_exercise3.model.Post;
import com.bootcamp.demo_exercise3.model.User;

@Component

public class PostEntityMapper {
  public List<PostEntity> map(List<UserEntity> u1,List<Post>p1){
List<PostEntity> list1= new ArrayList<>();

    for(int i=0;i<p1.size();i++){
      for(int k=0;k<u1.size();k++){
        if(p1.get(i).getUserId()==p1.get(k).getId()){
          list1.add(PostEntity.builder()
          .id(p1.get(i).getId()).body(p1.get(i).getBody())
          .title(p1.get(i).getTitle()).userEntity(u1.get(k)).build()) ;
        }
      }
    }return list1;
}

}
