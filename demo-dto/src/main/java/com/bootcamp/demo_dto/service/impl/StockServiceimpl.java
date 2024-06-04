package com.bootcamp.demo_dto.service.impl;

import java.util.List;
import java.util.stream.Collectors;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.demo_dto.ExceptionForStock.ListAddException;
import com.bootcamp.demo_dto.ExceptionForStock.UserNotFoundException;
import com.bootcamp.demo_dto.config.AppConfig;
import com.bootcamp.demo_dto.model.Stock;
import com.bootcamp.demo_dto.model.User;
import com.bootcamp.demo_dto.service.StockService;


@Service
public class StockServiceimpl implements StockService {

  @Autowired
  private AppConfig appConfig1;

  @Override
  public List<Stock> getAll() {
    return appConfig1.getUsers().stream() //
        .flatMap(e -> e.getStocks().stream()) //
        .collect(Collectors.toList());
  }

  @Override
  public Stock save(Stock stock, int userId) {
    // user id not found
    // add stock -> fail
    User user = appConfig1.getUsers().stream() //
        .filter(e -> e.getId() == userId) //
        .findAny() //
        .orElseThrow(() -> new UserNotFoundException());

    if (user.add(stock))
      return stock;
    throw new ListAddException();
  }

  
  
}
