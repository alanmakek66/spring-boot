package com.bootcamp.demo_bc_yahoo_finance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.bootcamp.demo_bc_yahoo_finance.entity.StocksEntity;

@Repository
public interface StocksEntityRepository extends JpaRepository<StocksEntity,Long> {
  
  
}
