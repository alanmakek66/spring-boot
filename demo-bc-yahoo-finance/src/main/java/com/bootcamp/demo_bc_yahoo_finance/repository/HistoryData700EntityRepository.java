package com.bootcamp.demo_bc_yahoo_finance.repository;

import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.bootcamp.demo_bc_yahoo_finance.entity2.Historydata700Entity;

@Repository
public interface HistoryData700EntityRepository
extends JpaRepository<Historydata700Entity,Long> {
  
}
