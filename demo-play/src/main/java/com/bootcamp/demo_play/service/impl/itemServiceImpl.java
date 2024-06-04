package com.bootcamp.demo_play.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.demo_play.config.Counter;
import com.bootcamp.demo_play.service.itemService;

@Service
public class itemServiceImpl implements itemService {

  @Autowired
  private Counter c11;

  @Override
  public int buy(String s1) throws NumberFormatException {

    try {
      int news1 = Integer.valueOf(s1);
    } catch (NumberFormatException n) {
      throw new NumberFormatException();
    }

    int news1 = Integer.valueOf(s1);

    if (news1 > c11.getItem()) {
      throw new NumberFormatException();
    }

    return c11.buyitem(news1);

  }

}
