package com.bootcamp.demo_spe1.service;

import com.bootcamp.demo_spe1.infra.NotFoundException;

public interface CalculatorService {
  String Caculate(String x, String y, String operation);
  String Caculate2(String x, String y, String operation) throws NotFoundException;
  String Caculate3(String x, String y, String operation) throws NotFoundException;
  
}
