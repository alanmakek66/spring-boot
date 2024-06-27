package com.bootcamp.demo_bc_yahoo_finance.service;

import java.util.List;

import com.bootcamp.demo_bc_yahoo_finance.entity2.Historydata005Entity;
import com.bootcamp.demo_bc_yahoo_finance.entity2.Historydata388Entity;
import com.bootcamp.demo_bc_yahoo_finance.entity2.Historydata700Entity;
import com.bootcamp.demo_bc_yahoo_finance.model2.HistoryData;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface HistoryDataService {
  List<Historydata388Entity> getHistoryData388() throws JsonProcessingException;

  List<Historydata700Entity> getHistoryData700() throws JsonProcessingException;
  List<Historydata005Entity> getHistoryData005() throws JsonProcessingException;

  void getHistoryData388ALL() throws JsonProcessingException;
  void getHistoryData700ALL() throws JsonProcessingException;
  void getHistoryData005ALL() throws JsonProcessingException;


  
}
