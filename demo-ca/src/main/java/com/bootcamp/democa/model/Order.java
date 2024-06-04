package com.bootcamp.democa.model;

import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails.Address;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class Order {
  private int id;
  private Address1 address;
  
}
