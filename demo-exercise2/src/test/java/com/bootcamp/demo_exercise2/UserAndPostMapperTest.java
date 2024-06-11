package com.bootcamp.demo_exercise2;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import com.bootcamp.demo_exercise2.dto.AdressDto;
import com.bootcamp.demo_exercise2.dto.CommentDto;
import com.bootcamp.demo_exercise2.dto.CompanyDto;
import com.bootcamp.demo_exercise2.dto.LocationDto;
import com.bootcamp.demo_exercise2.dto.PostAndCommentDto;
import com.bootcamp.demo_exercise2.dto.UserAndPostDto;
import com.bootcamp.demo_exercise2.dto.UserDto;
import com.bootcamp.demo_exercise2.dto.Mapper.UserAndPostMapper;

@WebMvcTest(UserAndPostMapper.class)
public class UserAndPostMapperTest {
  private static LocationDto ldo1;
  private static CompanyDto cdo1;
  private static AdressDto ado1;
  private static UserDto userDto;
  private static PostAndCommentDto pc1;
  private static CommentDto commentDto;

  @Autowired
  private UserAndPostMapper userAndPostMapper;

  @BeforeEach
  public void init() {

    ldo1 = LocationDto.builder()
        .lat("test")
        .lng("test")
        .build();

    cdo1 = CompanyDto.builder()
        .name("test")
        .catchPhrase("test")
        .business("test")
        .build();

    ado1 = AdressDto.builder()
        .street("test")
        .suite("test")
        .city("test")
        .zipcode("test")
        .geo(ldo1)
        .build();
    userDto = UserDto.builder().id("1").name("1")
        .username("1").website("1").phone("1").email("1").addressdto(ado1)
        .companydto(cdo1).build();

    commentDto = new CommentDto().builder().id("1").name("1").postId("1")
        .email("1").body("test").build();

    pc1 = new PostAndCommentDto()
        .builder().id("1").body("1").userId("1").body("test")
        .commentDtos(List.of(commentDto))
        .build();

  }

@Test 
void testMap(){
 List<UserAndPostDto> list1= userAndPostMapper.map(List.of(userDto), List.of(pc1));

 Assertions.assertEquals(list1.get(0).getId(), "1");
 Assertions.assertEquals(list1.get(0).getName(), "1");
 Assertions.assertEquals(list1.get(0).getUsername(), "1");
 Assertions.assertEquals(list1.get(0).getWebsite(), "1");
 Assertions.assertEquals(list1.get(0).getPostAndCommentDto().get(0).getId(), "1");
 Assertions.assertEquals(list1.get(0).getPostAndCommentDto().get(0).getBody(), "test");
 Assertions.assertEquals(list1.get(0).getPostAndCommentDto()
 .get(0).getCommentDtos().get(0).getEmail(), "1");
 Assertions.assertEquals(list1.get(0).getPostAndCommentDto()
 .get(0).getCommentDtos().get(0).getBody(), "test");
  
}

}
