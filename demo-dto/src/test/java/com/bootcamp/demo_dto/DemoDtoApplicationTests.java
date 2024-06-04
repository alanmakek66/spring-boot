package com.bootcamp.demo_dto;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.bootcamp.demo_dto.config.AppConfig;

@SpringBootTest
//100% simulating the actual@ springbootapplicaion

class DemoDtoApplicationTests {

	@Autowired
	private AppConfig appConfig;
	

	@Test
	void contextLoads() {
	}

}
