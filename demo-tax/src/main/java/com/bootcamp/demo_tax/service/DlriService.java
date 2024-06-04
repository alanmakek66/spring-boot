package com.bootcamp.demo_tax.service;

import java.util.List;

import com.bootcamp.demo_tax.infa.NotFoundException;
import com.bootcamp.demo_tax.model.DLRI;

public interface DlriService {
  List<DLRI> callApi();
  DLRI callApi2(String id) throws NotFoundException;
  DLRI callApi3(String email) throws NotFoundException;

  
}
