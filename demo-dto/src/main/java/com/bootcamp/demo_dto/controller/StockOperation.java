package com.bootcamp.demo_dto.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.bootcamp.demo_dto.dto.StockDto;
import com.bootcamp.demo_dto.model.Stock;
import com.bootcamp.demo_dto.model.User;


public interface StockOperation {

  @GetMapping(value = "/stock")
   List<StockDto> getStcok();

   @PostMapping(value = "/stock")
  Stock saveStock(@RequestBody Stock stock, @RequestParam int userId);
  
}
