package com.bootcamp.demo_exercise2;

import java.security.PublicKey;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import com.bootcamp.demo_exercise2.dto.CommentDto;
import com.bootcamp.demo_exercise2.dto.PostAndCommentDto;
import com.bootcamp.demo_exercise2.dto.PostDto;
import com.bootcamp.demo_exercise2.dto.UserAndPostDto;
import com.bootcamp.demo_exercise2.dto.Mapper.PostAndCommentMapper;

@WebMvcTest(PostAndCommentMapper.class)
public class PostAndCommentMapperTest {
  private static CommentDto commentDto;
  private static PostDto postDto;

  @Autowired
  private PostAndCommentMapper postAndCommentMapper;

  @BeforeAll
  public static void init() {
    commentDto = new CommentDto().builder().id("c1").name("1").postId("p1")
        .email("1").body("1").build();

    postDto = new PostDto().builder().id("p1").body("p1")
        .title("p1").userId("p1").build();
  }

  @Test
  public void testMap(){
    List<PostAndCommentDto> list1=postAndCommentMapper.map(List.of(postDto),List.of(commentDto));

    Assertions.assertEquals(list1.get(0).getId(), "p1");
    Assertions.assertEquals(list1.get(0).getBody(), "p1");
    Assertions.assertEquals(list1.get(0).getCommentDtos().get(0).getBody(),"1");
  }

}
