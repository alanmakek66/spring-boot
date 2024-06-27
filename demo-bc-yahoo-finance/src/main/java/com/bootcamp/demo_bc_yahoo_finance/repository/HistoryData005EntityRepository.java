package com.bootcamp.demo_bc_yahoo_finance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.demo_bc_yahoo_finance.entity2.Historydata005Entity;

@Repository
public interface HistoryData005EntityRepository 
extends JpaRepository<Historydata005Entity,Long> {
  
}
