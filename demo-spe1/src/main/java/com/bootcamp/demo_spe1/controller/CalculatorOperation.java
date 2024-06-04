package com.bootcamp.demo_spe1.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.bootcamp.demo_spe1.Dto.CalculatorDTO;
import com.bootcamp.demo_spe1.infra.NotFoundException;
import com.bootcamp.demo_spe1.model.Calculator;

public interface CalculatorOperation {
  @GetMapping(value = "/calculate")
  Object c1(@RequestParam String x,@RequestParam String y,
  @RequestParam String operation);

  @GetMapping(value = "/calculate/{x}/{y}/{operation}")
  Object c11(@PathVariable(value ="x") String x
  ,@PathVariable(value ="y") String y,@PathVariable(value ="operation") String operation);

  @GetMapping(value ="/c2")
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  Object c2(@RequestParam String x,@RequestParam String y,
  @RequestParam String operation)  throws NotFoundException ;

  @GetMapping(value = "/calculate2/{x}/{y}/{operation}")
  CalculatorDTO c22(@PathVariable(value ="x") String x
  ,@PathVariable(value ="y") String y,@PathVariable(value ="operation") String operation)
  throws NotFoundException;

  @PostMapping(value = "/calculate")
  Object CalculateSomething5(@RequestParam String x,@RequestParam String y,
  @RequestParam String operation);

  @PostMapping(value = "/p1")
  CalculatorDTO p1(@RequestParam String x,@RequestParam String y,
  @RequestParam String operation) throws NotFoundException;

   @PostMapping(value = "/p2")
   //@ResponseStatus(HttpStatus.BAD_REQUEST)
  CalculatorDTO p2(@RequestBody Calculator c1
 ) throws NotFoundException; 

 @GetMapping(value ="/c2e")
  //@ResponseStatus(HttpStatus.OK)
  Object c2e(@RequestParam String x,@RequestParam String y,
  @RequestParam String operation) throws NotFoundException ;

  
  
  
}
