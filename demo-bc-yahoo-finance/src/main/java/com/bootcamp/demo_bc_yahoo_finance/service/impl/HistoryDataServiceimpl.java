package com.bootcamp.demo_bc_yahoo_finance.service.impl;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bootcamp.demo_bc_yahoo_finance.entity2.Historydata005Entity;
import com.bootcamp.demo_bc_yahoo_finance.entity2.Historydata388Entity;
import com.bootcamp.demo_bc_yahoo_finance.entity2.Historydata700Entity;
import com.bootcamp.demo_bc_yahoo_finance.entity2.mapper.HistorydataEntityMapper;
import com.bootcamp.demo_bc_yahoo_finance.model2.HistoryData;
import com.bootcamp.demo_bc_yahoo_finance.repository.HistoryData005EntityRepository;
import com.bootcamp.demo_bc_yahoo_finance.repository.HistoryData388EntityRepository;
import com.bootcamp.demo_bc_yahoo_finance.repository.HistoryData700EntityRepository;
import com.bootcamp.demo_bc_yahoo_finance.service.HistoryDataService;
import com.fasterxml.jackson.core.JsonProcessingException;


@Service
public class HistoryDataServiceimpl implements HistoryDataService {
  @Autowired
  private HistoryData005EntityRepository historyData005EntityRepository;
  @Autowired
  private HistoryData700EntityRepository historyData700EntityRepository;
  @Autowired
  private HistoryData388EntityRepository historyData388EntityRepository;
  @Autowired
  private HistorydataEntityMapper historydataEntityMapper;

  @Override
  public List<Historydata388Entity> getHistoryData388() throws JsonProcessingException {
    

    return historyData388EntityRepository.findAll();

  }

  @Override
  public List<Historydata700Entity> getHistoryData700() throws JsonProcessingException {
    ;

    return historyData700EntityRepository.findAll();

  }

  @Override
  public List<Historydata005Entity> getHistoryData005() throws JsonProcessingException {
    

    return historyData005EntityRepository.findAll();

  }

  @Override
  public void getHistoryData388ALL() throws JsonProcessingException {
    RestTemplate r1 = new RestTemplate();

    LocalDateTime localDateTime = LocalDateTime.now();
    Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
    long unixTimestamp = instant.getEpochSecond();
    String unix = Long.valueOf(unixTimestamp).toString();

    String url = "https://query1.finance.yahoo.com/v8/finance/chart/0388.HK?period1=1696867200&period2="
        + unix + "&interval=1d&events=history&crumb=viya008zDer";// 2024-1-2 to now

    HistoryData h1 = r1.getForObject(url, HistoryData.class);

    
      String url2 = 
    "https://query1.finance.yahoo.com/v8/finance/chart/0388.HK?period1=1691424000&period2=1696867200&interval=1d&events=history&crumb=viya008zDer";

HistoryData h2 = r1.getForObject(url2, HistoryData.class); 

 String url3="https://query1.finance.yahoo.com/v8/finance/chart/0388.HK?period1=1665341341&period2=1691424000&interval=1d&events=history&crumb=viya008zDer";
// 2020 1 1 //2022 1 1
HistoryData h3 = r1.getForObject(url3, HistoryData.class);  
String url4="https://query1.finance.yahoo.com/v8/finance/chart/0005.HK?period1=1602270088&period2=1665341341&interval=1d&events=history&crumb=viya008zDer";
// 2017 to 2020(12) //1483200000 //1609344000
HistoryData h4 = r1.getForObject(url4, HistoryData.class); 


historyData388EntityRepository.deleteAll();

List<Historydata388Entity> data1=historydataEntityMapper.map(h1);
   List<Historydata388Entity> data2=historydataEntityMapper.map(h2); 
List<Historydata388Entity> data3=historydataEntityMapper.map(h3);   
List<Historydata388Entity> data4=historydataEntityMapper.map(h4);

historyData388EntityRepository.saveAll(data1);
   historyData388EntityRepository.saveAll(data2); 
 historyData388EntityRepository.saveAll(data3);  
 historyData388EntityRepository.saveAll(data4); 
 
 }
 @Override
  public void getHistoryData700ALL() throws JsonProcessingException {
    RestTemplate r1 = new RestTemplate();

    LocalDateTime localDateTime = LocalDateTime.now();
    Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
    long unixTimestamp = instant.getEpochSecond();
    String unix = Long.valueOf(unixTimestamp).toString();

    String url = "https://query1.finance.yahoo.com/v8/finance/chart/0700.HK?period1=1696867200&period2="
        + unix + "&interval=1d&events=history&crumb=viya008zDer";// 2024-1-2 to now

    HistoryData h1 = r1.getForObject(url, HistoryData.class);

    
    String url2 = 
    "https://query1.finance.yahoo.com/v8/finance/chart/0700.HK?period1=1691424000&period2=1696867200&interval=1d&events=history&crumb=viya008zDer";
//2021 to 2024;
HistoryData h2 = r1.getForObject(url2, HistoryData.class);

String url3="https://query1.finance.yahoo.com/v8/finance/chart/0700.HK?period1=1665341341&period2=1691424000&interval=1d&events=history&crumb=viya008zDer";
// 2017 to 2020(12) //1483200000 //1609344000
HistoryData h3 = r1.getForObject(url3, HistoryData.class); 
String url4="https://query1.finance.yahoo.com/v8/finance/chart/0700.HK?period1=1602270088&period2=1665341341&interval=1d&events=history&crumb=viya008zDer";
// 2017 to 2020(12) //1483200000 //1609344000
HistoryData h4 = r1.getForObject(url4, HistoryData.class); 


historyData700EntityRepository.deleteAll();

List<Historydata700Entity> data1=historydataEntityMapper.map2(h1);
 List<Historydata700Entity> data2=historydataEntityMapper.map2(h2);
List<Historydata700Entity> data3=historydataEntityMapper.map2(h3); 
List<Historydata700Entity> data4=historydataEntityMapper.map2(h4);
historyData700EntityRepository.saveAll(data1);
historyData700EntityRepository.saveAll(data2);
historyData700EntityRepository.saveAll(data3); 
historyData700EntityRepository.saveAll(data4); 

 }

 @Override
  public void getHistoryData005ALL() throws JsonProcessingException {
    RestTemplate r1 = new RestTemplate();

    LocalDateTime localDateTime = LocalDateTime.now();
    Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
    long unixTimestamp = instant.getEpochSecond();
    String unix = Long.valueOf(unixTimestamp).toString();

    String url = "https://query1.finance.yahoo.com/v8/finance/chart/0005.HK?period1=1696867200&period2="
        + unix + "&interval=1d&events=history&crumb=viya008zDer";// 2024-1-2 to now

    HistoryData h1 = r1.getForObject(url, HistoryData.class);

    
     String url2 = 
     "https://query1.finance.yahoo.com/v8/finance/chart/0005.HK?period1=1691424000&period2=1696867200&interval=1d&events=history&crumb=viya008zDer";
     //2021 to 2024;
HistoryData h2 = r1.getForObject(url2, HistoryData.class);

String url3="https://query1.finance.yahoo.com/v8/finance/chart/0005.HK?period1=1665341341&period2=1691424000&interval=1d&events=history&crumb=viya008zDer";
// 2017 to 2020(12) //1483200000 //1609344000
HistoryData h3 = r1.getForObject(url3, HistoryData.class); 
String url4="https://query1.finance.yahoo.com/v8/finance/chart/0005.HK?period1=1602270088&period2=1665341341&interval=1d&events=history&crumb=viya008zDer";
// 2017 to 2020(12) //1483200000 //1609344000
HistoryData h4 = r1.getForObject(url4, HistoryData.class); 

historyData005EntityRepository.deleteAll();

List<Historydata005Entity> data1=historydataEntityMapper.map3(h1);
 List<Historydata005Entity> data2=historydataEntityMapper.map3(h2);
List<Historydata005Entity> data3=historydataEntityMapper.map3(h3); 
List<Historydata005Entity> data4=historydataEntityMapper.map3(h4); 

historyData005EntityRepository.saveAll(data1);
historyData005EntityRepository.saveAll(data2);
historyData005EntityRepository.saveAll(data3); 
historyData005EntityRepository.saveAll(data4); 

 }

}
