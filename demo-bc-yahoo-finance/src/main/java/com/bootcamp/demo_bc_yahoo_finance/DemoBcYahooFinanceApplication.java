package com.bootcamp.demo_bc_yahoo_finance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableAsync
@EnableScheduling
public class DemoBcYahooFinanceApplication {
	@Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper;
    }

	public static void main(String[] args) {
		SpringApplication.run(DemoBcYahooFinanceApplication.class, args);
	}

}
