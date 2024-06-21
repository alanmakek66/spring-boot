package com.bootcamp.demo_sch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableAsync

public class DemoSchApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoSchApplication.class, args);
	}

}
