package com.bootcamp.demo_dto.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

import com.bootcamp.demo_dto.dto.StockDto;
import com.bootcamp.demo_dto.model.Stock;
import com.bootcamp.demo_dto.service.StockService;

@RestController
public class StockController implements StockOperation {

  @Autowired
  private StockService stockService;

  @Override
  public List<StockDto> getStcok() {
     return stockService.getAll().stream().collect(Collectors.groupingBy(e->e.getId(),
     Collectors.summingInt(e->e.getQuantity()))).
     entrySet().stream().map(e->new StockDto(e.getKey(), e.getValue())).
     collect(Collectors.toList());
  
  
}

 @Override
  public Stock saveStock(@RequestBody Stock stock, @RequestParam int userId) {
    return stockService.save(stock, userId);

  }
  //demo responseEntity

  @GetMapping(value = "/test/{id}")
  public ResponseEntity<Stock> demotestEntity(@PathVariable String id){
    Stock stock1 =null;

    return ResponseEntity.badRequest().build();
  }

  
}
