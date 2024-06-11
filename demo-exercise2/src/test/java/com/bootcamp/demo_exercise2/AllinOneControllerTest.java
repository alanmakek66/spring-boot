package com.bootcamp.demo_exercise2;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.bootcamp.demo_exercise2.controller.impl.AllinOneController;
import com.bootcamp.demo_exercise2.dto.AdressDto;
import com.bootcamp.demo_exercise2.dto.CommentDto;
import com.bootcamp.demo_exercise2.dto.CompanyDto;
import com.bootcamp.demo_exercise2.dto.GetUserByidDto;
import com.bootcamp.demo_exercise2.dto.LocationDto;
import com.bootcamp.demo_exercise2.dto.PostAndCommentDto;
import com.bootcamp.demo_exercise2.dto.UserAndPostDto;
import com.bootcamp.demo_exercise2.dto.Mapper.GetUserByidMapper;
import com.bootcamp.demo_exercise2.service.AllinoneService;

@WebMvcTest(AllinOneController.class)
public class AllinOneControllerTest {
        private static LocationDto ldo1;
        private static CompanyDto cdo1;
        private static AdressDto ado1;
        private static PostAndCommentDto pc1;
        private static CommentDto commentDto1;
        private static UserAndPostDto userAndPostDto1;

        @MockBean
        private AllinoneService allinoneService;

        @MockBean
        private GetUserByidMapper getUserByidMapper;

        @Autowired
        private MockMvc mm;

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
                commentDto1 = new CommentDto().builder().id("1").name("1").postId("1")
                                .email("1").body("1").build();

                pc1 = new PostAndCommentDto()
                                .builder().id("1").body("1").userId("1").body("1")
                                .commentDtos(List.of(commentDto1))
                                .build();

                userAndPostDto1 = new UserAndPostDto().builder()
                                .id("1")
                                .name("test")
                                .username("test")
                                .email("test")
                                .addressdto(ado1)
                                .website("test")
                                .phone("test")
                                .company(cdo1)
                                .PostAndCommentDto(List.of(pc1))
                                .build();
        }

        @Test
        void testgetall() throws Exception {
                LocationDto ldo = LocationDto.builder()
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

                CommentDto commentDto = new CommentDto().builder().id("1").name("1").postId("1")
                                .email("1").body("1").build();

                PostAndCommentDto pc1 = new PostAndCommentDto()
                                .builder().id("1").body("1").userId("1").body("1")
                                .commentDtos(List.of(commentDto))
                                .build();

                UserAndPostDto test1 = new UserAndPostDto().builder()
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

                Mockito.when(allinoneService.getdata()).thenReturn(List.of(userAndPostDto1));

                mm.perform(MockMvcRequestBuilders.get("/getall"))
                                .andExpect(status().isOk())//
                                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id", is("1")))
                                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name", is("test")))
                                .andExpect(MockMvcResultMatchers.jsonPath("$[0].username", is("test")))
                                .andExpect(MockMvcResultMatchers.jsonPath("$[0].website", is("test")))
                                .andExpect(MockMvcResultMatchers.jsonPath("$[0].phone", is("test")))
                                .andExpect(MockMvcResultMatchers.jsonPath("$[0].posts[0].body",
                                                is("1")));

        }

        @Test
        void testGetUserByidDto() throws Exception {

                CommentDto commentDto = new CommentDto().builder().id("1").name("1").postId("1")
                                .email("1").body("1").build();

                GetUserByidDto result = new GetUserByidDto().builder()
                                .id("1").username("1").CommentDto(List.of(commentDto)).build();

                Mockito.when(allinoneService.getUserById2("1")).thenReturn(result);

                mm.perform(MockMvcRequestBuilders.get("/v1/id").param("id", "1"))
                                .andExpect(MockMvcResultMatchers.jsonPath("$.id", is("1")))
                                .andExpect(MockMvcResultMatchers.jsonPath("$.username", is("1")))
                                .andExpect(MockMvcResultMatchers.jsonPath("$.commentDto[0].email", is("1")));

                when(allinoneService.getUserById2("a")).thenThrow(new NumberFormatException());
                mm.perform(MockMvcRequestBuilders.get("/v1/id").param("id", "a"))
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code", is(2)));
                


        }

}
