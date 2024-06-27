package com.bootcamp.demo_bc_yahoo_finance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.demo_bc_yahoo_finance.entity2.Historydata388Entity;

@Repository
public interface HistoryData388EntityRepository 
extends JpaRepository<Historydata388Entity,Long> {
  
}
