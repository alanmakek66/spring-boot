package com.example.demo_student1;
import static org.hamcrest.Matchers.containsInAnyOrder;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.Matchers.is;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.demo_student1.controller.StudentController;
import com.example.demo_student1.model.Subject1;
import com.example.demo_student1.service.StudentService;

@WebMvcTest(StudentController.class)
public class StudentControllerTest {
  @Autowired
  private StudentController sc1;
  
  @MockBean
  private StudentService sds1;

  @Autowired
  private MockMvc mockMvc; 
  

  @Test
  public void testSubject() throws Exception{
    List<Subject1> ss = new ArrayList<>(List.of(Subject1.Chinese, Subject1.English, Subject1.Maths));

    Mockito.when(sds1.getSubjectByname("Tom")).thenReturn(ss);

    mockMvc.perform(MockMvcRequestBuilders.get("/subject?name=Tom"))
    .andExpect(MockMvcResultMatchers.jsonPath("$[*]",
    containsInAnyOrder(Subject1.Chinese.name(), Subject1.English.name(), Subject1.Maths.name())));


  }

  
  
}
