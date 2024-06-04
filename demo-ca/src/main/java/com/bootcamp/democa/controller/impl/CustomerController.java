package com.bootcamp.democa.controller.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootcamp.democa.controller.CustomerOperation;
import com.bootcamp.democa.model.Address1;
import com.bootcamp.democa.model.Customer;
import com.bootcamp.democa.model.Order;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@ResponseBody
public class CustomerController implements CustomerOperation {

  //@GetMapping(value = "/getCustomer")
  @Override
  public List<Customer> getCustomer(){

    Order o1 =new Order(1, new Address1("ad", null, null));
    new Customer("Vincent", "03-10-2013", new ArrayList<>(List.of(o1)));
    new Customer("Jenny", "03-10-2013", new ArrayList<>(List.of(o1)));
    return 
    new ArrayList<>(List.of(new Customer("Vincent", "03-10-2013", new ArrayList<>(List.of(o1))),new Customer("Jenny", "03-10-2013", new ArrayList<>(List.of(o1)))));
    

  }
  
  
  
}
