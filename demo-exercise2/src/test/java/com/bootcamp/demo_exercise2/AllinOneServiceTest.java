package com.bootcamp.demo_exercise2;



import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Lazy;
import org.springframework.test.web.servlet.MockMvc;

import com.bootcamp.demo_exercise2.dto.AdressDto;
import com.bootcamp.demo_exercise2.dto.CommentDto;
import com.bootcamp.demo_exercise2.dto.CompanyDto;
import com.bootcamp.demo_exercise2.dto.LocationDto;
import com.bootcamp.demo_exercise2.dto.PostAndCommentDto;
import com.bootcamp.demo_exercise2.dto.PostDto;
import com.bootcamp.demo_exercise2.dto.UserAndPostDto;
import com.bootcamp.demo_exercise2.dto.UserDto;
import com.bootcamp.demo_exercise2.dto.Mapper.CommentDtoMapper;
import com.bootcamp.demo_exercise2.dto.Mapper.GetUserByidMapper;
import com.bootcamp.demo_exercise2.dto.Mapper.PostAndCommentMapper;
import com.bootcamp.demo_exercise2.dto.Mapper.PostDtoMapper;
import com.bootcamp.demo_exercise2.dto.Mapper.UserAndPostMapper;
import com.bootcamp.demo_exercise2.dto.Mapper.UserDtoMapper;
import com.bootcamp.demo_exercise2.model.Comment;
import com.bootcamp.demo_exercise2.model.Post;
import com.bootcamp.demo_exercise2.model.User;
import com.bootcamp.demo_exercise2.model.User.Address;
import com.bootcamp.demo_exercise2.model.User.Company;
import com.bootcamp.demo_exercise2.model.User.Address.Location;
import com.bootcamp.demo_exercise2.service.AllinoneService;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.assertj.core.api.Assertions.assertThat;



@SpringBootTest
public class AllinOneServiceTest {
  


@Autowired
private GetUserByidMapper getUserByidMapper;
@Autowired
private UserDtoMapper userDtoMapper;

 @Autowired
  private PostDtoMapper postDtoMapper1; 

  @Autowired
  private PostAndCommentMapper postAndCommentMapper;

  @Autowired
  private CommentDtoMapper commentDtoMapper1;

  @Autowired
  private UserAndPostMapper userAndPostMapper;

  @MockBean
  private AllinoneService allinoneService;

  @BeforeAll
  void init(){

  }
 
  @Test 
  void testgetComment() throws Exception{
String json= "[{\"postId\":\"1\",\"id\":\"1\",\"name\":\"test\",\"email\":\"test\",\"body\":\"test\"}]";

Comment expectedComment=new Comment().builder().postId("1")
.id("1").name("test")
.email("test").body("test").build();

Mockito.when(allinoneService.getcommnet()).thenReturn(List.of(expectedComment));

List<Comment> c1=allinoneService.getcommnet();
ObjectMapper objMapper= new ObjectMapper();

String actualJson=objMapper.writeValueAsString(c1);
Assertions.assertEquals(json, actualJson);
  }
  @Test 
  void testgetPost() throws Exception{
String json= "[{\"userId\":\"1\",\"id\":\"1\",\"title\":\"test\",\"body\":\"test\"}]";

Post expectedPost=new Post().builder().userId("1")
.id("1").title("test")
.body("test").build();

Mockito.when(allinoneService.getpost()).thenReturn(List.of(expectedPost));

List<Post> p1=allinoneService.getpost();
ObjectMapper objMapper= new ObjectMapper();

String actualJson=objMapper.writeValueAsString(p1);
Assertions.assertEquals(json, actualJson);}

@Test 
  void testgetData() throws Exception{

Post expectedPost=new Post().builder().userId("1")
.id("1").title("test")
.body("test").build();
Comment expectedComment=new Comment().builder().postId("1")
.id("1").name("test")
.email("test").body("test").build();
Mockito.when(allinoneService.getpost()).thenReturn(List.of(expectedPost));
Mockito.when(allinoneService.getcommnet()).thenReturn(List.of(expectedComment));

Location expectedLocation=new Location().builder()
.lat("test").lng("test").build();

Address expectedAddress= new User.Address().builder().street("test").suite("test")
.zipcode("test").city("test").geo(expectedLocation).build();

Company expectedCompany= new User.Company().builder().name("test").catchPhrase("test")
.business("test").build();

User expectedUser= new User().builder().id("1").username("abc")
.name("aa").email("test").website("test").phone("test").address(expectedAddress)
.company(expectedCompany).build();

Mockito.when(allinoneService.getusers()).thenReturn(List.of(expectedUser));

List<CommentDto> commentDtos=new ArrayList<>(List.of(expectedComment)
.stream().map(e->commentDtoMapper1.map(e)).collect(Collectors.toList()));
Assertions.assertEquals(commentDtos.get(0).getId(),List.of(expectedComment).get(0).getId());

List<PostDto> postDtos=new ArrayList<>(List.of(expectedPost)
.stream().map(e->postDtoMapper1.map(e)).collect(Collectors.toList()));
Assertions.assertEquals(postDtos.get(0).getId(),List.of(expectedPost).get(0).getId());

postAndCommentMapper.map(postDtos, commentDtos);
Assertions.assertEquals(postDtos.get(0).getId(),
 postAndCommentMapper.map(postDtos, commentDtos).get(0).getId());

 List<UserDto> userDtos = new ArrayList<>(List.of(expectedUser)
 .stream().map(e->userDtoMapper.map(e)).collect(Collectors.toList()));
 Assertions.assertEquals(userDtos.get(0).getId(),List.of(expectedUser).get(0).getId());

 List<UserAndPostDto> list1
 =userAndPostMapper.map(userDtos, postAndCommentMapper.map(postDtos, commentDtos));

 Assertions.assertEquals(list1.get(0).getId(), userDtos.get(0).getId());
 Assertions.assertEquals(list1.get(0).getEmail(),userDtos.get(0).getEmail());
 ;

  }

@Test
void testgetUserById2(){
  LocationDto ldo=LocationDto.builder()
    .lat("test")
    .lng("test")
    .build();

    

    CompanyDto cdo = CompanyDto.builder()
        .name("test")
        .catchPhrase("test")
        .business("test")
        .build();

        AdressDto ado = AdressDto.builder()
        .street("test")
        .suite("test")
        .city("test")
        .zipcode("test")
        .geo(ldo)
        .build();
        
        Comment expectedComment=new Comment().builder().postId("1")
        .id("1").name("test")
        .email("test").body("test").build();
        
        Mockito.when(allinoneService.getcommnet()).thenReturn(List.of(expectedComment));

        PostAndCommentDto pc1=new PostAndCommentDto()
        .builder().id("1").body("1").userId("1").body("1")
        .commentDtos(List.of(expectedComment).stream()
        .map(e->commentDtoMapper1.map(e)).collect(Collectors.toList()))
        .build();


  UserAndPostDto test1= new UserAndPostDto().builder()
.id("1")
    .name("test")
    .username("test")
    .email("test")
    .addressdto(ado)
    .website("test")
    .phone("test")
    .company(cdo)
    .PostAndCommentDto(List.of(pc1))
    .build();


    

Mockito.when(allinoneService.getdata()).thenReturn(List.of(test1));

Assertions.assertEquals(test1.getId()
, getUserByidMapper.map(allinoneService.getdata().get(0)).getId());




}

}

  

