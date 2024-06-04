package com.bootcamp.democa.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

import com.bootcamp.democa.model.Customer;

public interface CustomerOperation {
  
  @GetMapping(value = "/getCustomer")
  List<Customer> getCustomer();


  
}
