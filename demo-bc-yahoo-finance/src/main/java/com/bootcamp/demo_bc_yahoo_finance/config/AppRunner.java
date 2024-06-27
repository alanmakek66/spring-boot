package com.bootcamp.demo_bc_yahoo_finance.config;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.bootcamp.demo_bc_yahoo_finance.holiday.Holiday;
import com.bootcamp.demo_bc_yahoo_finance.model.Stock;
import com.bootcamp.demo_bc_yahoo_finance.service.HistoryDataService;
import com.bootcamp.demo_bc_yahoo_finance.service.KeyService;
import com.bootcamp.demo_bc_yahoo_finance.service.StockService;
import com.fasterxml.jackson.core.JsonProcessingException;

@Component
public class AppRunner implements CommandLineRunner   {

  
  @Autowired
  private KeyService keyService;
  @Autowired 
  private StockService stockService;
  @Autowired
  private Holiday holiday;
  @Autowired
  private HistoryDataService historyDataService;

  @Override
  //@Scheduled(fixedRate = 5 * 60 * 1000)
  //@Scheduled(cron = "0 0 0 * * ?")
  //@Scheduled(cron = "0 0 0 ? * Fri")
  //@Scheduled(cron = "0 0 0 1 * ?")

  public void run(String... args){
    stockService.addDate();
    stockService.cleanAllSysDate();


 }

 @Scheduled(cron = "1 0/5 9-17 ? * MON-FRI")
 public void update(){
  if(!(holiday.isHoliday(LocalDate.now()))){
  stockService.update5mindata();}
  else{

  }

 }

 @Scheduled(cron = "0 0 0 * * ?")
 public void update2(){
  stockService.updateDailydata();
 

  }

 

 @Scheduled(cron = "0 55 8 * * ?")
 public void updateSysDate(){
  stockService.cleanAllSysDate();

}

@Scheduled(cron = "0 39 23 ? * MON-FRI")
public void updatehistory() throws JsonProcessingException{
  historyDataService.getHistoryData388ALL();
  historyDataService.getHistoryData700ALL();
  historyDataService.getHistoryData005ALL();


}

}

 


  

