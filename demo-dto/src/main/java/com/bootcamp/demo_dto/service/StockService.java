package com.bootcamp.demo_dto.service;

import java.util.List;

import javax.naming.NameNotFoundException;

import com.bootcamp.demo_dto.model.Stock;

public interface StockService {

  List<Stock> getAll();

Stock save(Stock stock, int userId)throws RuntimeException ;
}
