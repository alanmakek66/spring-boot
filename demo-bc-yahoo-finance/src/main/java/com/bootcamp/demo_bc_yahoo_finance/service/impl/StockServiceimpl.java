package com.bootcamp.demo_bc_yahoo_finance.service.impl;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bootcamp.demo_bc_yahoo_finance.entity.Data005forRedis;
import com.bootcamp.demo_bc_yahoo_finance.entity.Data388forRedis;
import com.bootcamp.demo_bc_yahoo_finance.entity.Data700forRedis;
import com.bootcamp.demo_bc_yahoo_finance.entity.DataforCache;
import com.bootcamp.demo_bc_yahoo_finance.entity.StocksEntity;
import com.bootcamp.demo_bc_yahoo_finance.entity.SysDate005Entity;
import com.bootcamp.demo_bc_yahoo_finance.entity.SysDate388Entity;
import com.bootcamp.demo_bc_yahoo_finance.entity.SysDate700Entity;
import com.bootcamp.demo_bc_yahoo_finance.entity.YahooStockEntity;
import com.bootcamp.demo_bc_yahoo_finance.entity.mapper.DataCacheMapper;
import com.bootcamp.demo_bc_yahoo_finance.entity.mapper.SysDateMapper;
import com.bootcamp.demo_bc_yahoo_finance.entity.mapper.YahooStockEntityMapper;
import com.bootcamp.demo_bc_yahoo_finance.holiday.Holiday;
import com.bootcamp.demo_bc_yahoo_finance.infa.NotFoundException;
import com.bootcamp.demo_bc_yahoo_finance.model.Stock;
import com.bootcamp.demo_bc_yahoo_finance.repository.StocksEntityRepository;
import com.bootcamp.demo_bc_yahoo_finance.repository.YahooStockEntityRepository;
import com.bootcamp.demo_bc_yahoo_finance.service.KeyService;
import com.bootcamp.demo_bc_yahoo_finance.service.StockService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;



@Service
public class StockServiceimpl implements StockService {

  @Value(value = "axids=gam=y-nxFEVL1E2uIC7PPVN5DUUVNh1UeM5.AW~A&dv360=eS1BdnhoXzJsRTJ1R3J6bkxDX0s3OEpLWFZKNHRJRFpoeX5B&ydsp=y-cvmxHTtE2uJUnRRhliUYqZz9Wa56HYKI~A&tbla=y-7DSuISpE2uKjbyY36cwTMrPUPeSJwTmP~A; tbla_id=47ceab98-63cb-4d96-9782-7b012cfb23fd-tuctcfccde1; GUC=AQEBCAFmUYZmfEIeAQQ1&s=AQAAAMDyJh6_&g=ZlA_4A; A1=d=AQABBJdoAWYCEH0T7ZiiYn7_FtrxZFoo43oFEgEBCAGGUWZ8Zliia3sB_eMBAAcIl2gBZloo43o&S=AQAAAvvMR5RDLnciRmuUu3RDK5o; A3=d=AQABBJdoAWYCEH0T7ZiiYn7_FtrxZFoo43oFEgEBCAGGUWZ8Zliia3sB_eMBAAcIl2gBZloo43o&S=AQAAAvvMR5RDLnciRmuUu3RDK5o; cmp=t=1718272033&j=0&u=1---; PRF=t%3D%255EIXIC%252B0388.HK; A1S=d=AQABBJdoAWYCEH0T7ZiiYn7_FtrxZFoo43oFEgEBCAGGUWZ8Zliia3sB_eMBAAcIl2gBZloo43o&S=AQAAAvvMR5RDLnciRmuUu3RDK5o") // required
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               // =
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               // true
  private String cookies;

  @Autowired
  private KeyService keyService;
  @Autowired
  private StocksEntityRepository stocksEntityRepository;
  @Autowired
  private RedisTemplate<String, String> redisTemplate;
  @Autowired
  private YahooStockEntityRepository yahooStockEntityRepository;
  @Autowired
  private YahooStockEntityMapper yahooStockEntityMapper;
  @Autowired
  private ObjectMapper objectMapper;
  @Autowired
  private Holiday holiday;
  @Autowired
  private SysDateMapper sysDateMapper;
  @Autowired
  private DataCacheMapper dataCacheMapper;

  @Override
  public void addDate() {

    StocksEntity s1 = new StocksEntity("0700.HK");
    StocksEntity s2 = new StocksEntity("0388.HK");
    StocksEntity s3 = new StocksEntity("0005.HK");
    List<StocksEntity> stocksEntities = List.of(s1, s2, s3);
    try {
      stocksEntityRepository.saveAll(stocksEntities);
    } catch (DataIntegrityViolationException e) {

    }

  }

  @Override
  public List<StocksEntity> list() throws JsonProcessingException {
    // ObjectMapper objectMapper = new ObjectMapper();

    String stocks = redisTemplate.opsForValue().get("stocks-list");
    if (stocks != null) {

      return List.of(objectMapper.readValue(stocks, StocksEntity[].class));
    } else {
      List<StocksEntity> stocksEntities = stocksEntityRepository.findAll();
      String json = objectMapper.writeValueAsString(stocksEntities);
      this.redisTemplate.opsForValue().set("stocks-list", json);

      return stocksEntities;

    }

  }

  @Override
  public List<YahooStockEntity> get5mindate(String symbol, String type) throws JsonProcessingException {

    LocalDateTime current = LocalDateTime.now();
    LocalTime targetTime = LocalTime.of(8, 55);
    LocalDateTime targetDateTime = LocalDateTime.of(current.toLocalDate(), targetTime);
    LocalDateTime searchTime = null;

    List<YahooStockEntity> AllData = new ArrayList<>();

    String allRedisDate = redisTemplate.opsForValue().get("5min");

    if (allRedisDate != null) {
      AllData = Arrays.asList(objectMapper.readValue(allRedisDate, YahooStockEntity[].class));

    } else {
      List<YahooStockEntity> yahooStockEntity = yahooStockEntityRepository.findAll();
      String json = objectMapper.writeValueAsString(yahooStockEntity);
      this.redisTemplate.opsForValue().set("5min", json);
      AllData = yahooStockEntity;

    }
    ;

    if (current.isBefore(targetDateTime)) {
      LocalDate workingday = holiday.getPreviousWorkingDay(current.toLocalDate());
      LocalDateTime workingdaytime = workingday.atStartOfDay();
      searchTime = workingdaytime;
    } else if (current.isAfter(targetDateTime) && !(holiday.isHoliday(current.toLocalDate()))) {
      searchTime = current;

    } else if (holiday.isHoliday(current.toLocalDate())) {
      searchTime = holiday.getPreviousWorkingDay(current.toLocalDate()).atStartOfDay();

    }

    LocalDate seacrhDate = searchTime.toLocalDate();

    List<YahooStockEntity> targetData = AllData.stream()
        .filter(e -> e.getSymbol().equals(symbol) &&
            e.getType().equals(type) && e.getApiDatetime().toLocalDate().equals(seacrhDate))
        .collect(Collectors.toList());

    return targetData;

  }

  @Override
  public void update5mindata() {
    String key = keyService.hardCodeCrumb();

    RestTemplate r1 = new RestTemplate();
    String url388 = "https://query1.finance.yahoo.com/v7/finance/quote?symbols=0388.HK&crumb=" + key;

    String url700 = "https://query1.finance.yahoo.com/v7/finance/quote?symbols=0700.HK&crumb=" + key;
    String url005 = "https://query1.finance.yahoo.com/v7/finance/quote?symbols=0005.HK&crumb=" + key;

    HttpHeaders headers = new HttpHeaders();
    headers.set("Cookie", cookies);
    HttpEntity<Void> entity = new HttpEntity<>(headers);

    ResponseEntity<Stock> response1 = r1.exchange(url388, HttpMethod.GET, entity, Stock.class);
    ResponseEntity<Stock> response2 = r1.exchange(url700, HttpMethod.GET, entity, Stock.class);
    ResponseEntity<Stock> response3 = r1.exchange(url005, HttpMethod.GET, entity, Stock.class);

    YahooStockEntity yahooStockEntity388 = yahooStockEntityMapper.map5m(response1.getBody());
    YahooStockEntity yahooStockEntity700 = yahooStockEntityMapper.map5m(response2.getBody());
    YahooStockEntity yahooStockEntity005 = yahooStockEntityMapper.map5m(response3.getBody());

    yahooStockEntityRepository.save(yahooStockEntity388);
    yahooStockEntityRepository.save(yahooStockEntity700);
    yahooStockEntityRepository.save(yahooStockEntity005);

    redisTemplate.delete("5min");
    redisTemplate.delete("5MIN-0700.HK");
    redisTemplate.delete("5MIN-0388.HK");
    redisTemplate.delete("5MIN-0005.HK");

  }

  

  @Override
  public void cleanAllSysDate() {
    redisTemplate.delete("sysdate388");
    redisTemplate.delete("sysdate700");
    redisTemplate.delete("sysdate005");

  }

  @Override
  public SysDate388Entity getSysDate388(String symbol) throws JsonProcessingException {
    String sysDate388 = redisTemplate.opsForValue().get("SYSDATE-388");

    if (sysDate388 != null) {
      SysDate388Entity sysDate388Entity =  objectMapper.readValue(sysDate388, SysDate388Entity.class);
      return sysDate388Entity;

    } else {
      YahooStockEntity yahooStockEntity = yahooStockEntityRepository.getLatestDataBySymbol(symbol);

      SysDate388Entity sysDate388Entity = sysDateMapper.map388(yahooStockEntity);
      String json = objectMapper.writeValueAsString(sysDate388Entity);

      redisTemplate.opsForValue().set("SYSDATE-388", json, Duration.ofHours(4));

      return sysDate388Entity;

    }
  }

  @Override
  public SysDate700Entity getSysDate700(String symbol) throws JsonProcessingException {

    String sysDate700 = redisTemplate.opsForValue().get("SYSDATE-700");
    // SysDate700Entity sysDate700Entity=null;

    if (sysDate700 != null) {
      SysDate700Entity sysDate700Entity = objectMapper.readValue(sysDate700, SysDate700Entity.class);
      return sysDate700Entity;

    } else {
      YahooStockEntity yahooStockEntity = yahooStockEntityRepository.getLatestDataBySymbol(symbol);

      SysDate700Entity sysDate700Entity = sysDateMapper.map700(yahooStockEntity);
      String json = objectMapper.writeValueAsString(sysDate700Entity);

      redisTemplate.opsForValue().set("SYSDATE-700", json, Duration.ofHours(4));

      return sysDate700Entity;

    }

  }

  @Override
  public SysDate005Entity getSysDate005(String symbol) throws JsonProcessingException {
    String sysDate005 = redisTemplate.opsForValue().get("SYSDATE-005");
    // SysDate700Entity sysDate700Entity=null;

    if (sysDate005 != null) {
      SysDate005Entity sysDate005Entity = objectMapper.readValue(sysDate005, SysDate005Entity.class);
      return sysDate005Entity;

    } else {
      YahooStockEntity yahooStockEntity = yahooStockEntityRepository.getLatestDataBySymbol(symbol);

      SysDate005Entity sysDate005Entity = sysDateMapper.map005(yahooStockEntity);
      String json = objectMapper.writeValueAsString(sysDate005Entity);

      redisTemplate.opsForValue().set("SYSDATE-005", json, Duration.ofHours(4));

      return sysDate005Entity;

    }

  }

  @Override
  public Data388forRedis getDataforRedis388() throws JsonProcessingException {
    YahooStockEntity dated1=
    yahooStockEntityRepository.findLatestData().orElseThrow(()->new NotFoundException());

    String sysdate=dated1.getMarketTime().toLocalDate().toString();

    String data388 = redisTemplate.opsForValue().get("5MIN-0388.HK");

    if (data388 != null) {
      Data388forRedis data388forRedis = objectMapper.readValue(data388, Data388forRedis.class);
      return data388forRedis;
    } else {
      List<YahooStockEntity> yahooStockEntities = yahooStockEntityRepository.findAll()
          .stream().filter(e -> e.getSymbol().equals("0388.HK")
              && e.getType().equals("5min") && e.getMarketTime().toLocalDate().toString().equals(sysdate))
          .collect(Collectors.toList());

      List<DataforCache> dataforCaches = yahooStockEntities.stream()
          .map(e -> dataCacheMapper.map(e)).collect(Collectors.toList());

      Data388forRedis data388forRedis = new Data388forRedis(dataforCaches);
      String json = objectMapper.writeValueAsString(data388forRedis);

      redisTemplate.opsForValue().set("5MIN-0388.HK", json,Duration.ofMinutes(5));
      return data388forRedis;

    }

  }

  @Override
  public Data700forRedis getDataforRedis700() throws JsonProcessingException {
    //String sysdate = redisTemplate.opsForValue().get("SYSDATE-700");

    YahooStockEntity dated1=
    yahooStockEntityRepository.findLatestData().orElseThrow(()->new NotFoundException());

    String sysdate=dated1.getMarketTime().toLocalDate().toString();

    String data700 = redisTemplate.opsForValue().get("5MIN-0700.HK");

    if (data700 != null) {
      Data700forRedis data700forRedis = objectMapper.readValue(data700, Data700forRedis.class);
      return data700forRedis;
    } else {
      List<YahooStockEntity> yahooStockEntities = yahooStockEntityRepository.findAll()
          .stream().filter(e -> e.getSymbol().equals("0700.HK")
              && e.getType().equals("5min") && e.getMarketTime().toLocalDate().toString().equals(sysdate))
          .collect(Collectors.toList());

      List<DataforCache> dataforCaches = yahooStockEntities.stream()
          .map(e -> dataCacheMapper.map(e)).collect(Collectors.toList());

      Data700forRedis data700forRedis = new Data700forRedis(dataforCaches);
      String json = objectMapper.writeValueAsString(data700forRedis);

      redisTemplate.opsForValue().set("5MIN-0700.HK", json,Duration.ofMinutes(5));
      return data700forRedis;

    }

  }

  @Override
  public Data005forRedis getDataforRedis005() throws JsonProcessingException {
    YahooStockEntity dated1=
    yahooStockEntityRepository.findLatestData().orElseThrow(()->new NotFoundException());

    String sysdate=dated1.getMarketTime().toLocalDate().toString();

    String data005 = redisTemplate.opsForValue().get("5MIN-0005.HK");

    if (data005 != null) {
      Data005forRedis data005forRedis = objectMapper.readValue(data005, Data005forRedis.class);
      return data005forRedis;
    } else {
      List<YahooStockEntity> yahooStockEntities = yahooStockEntityRepository.findAll()
          .stream().filter(e -> e.getSymbol().equals("0005.HK")
              && e.getType().equals("5min") && e.getMarketTime().toLocalDate().toString().equals(sysdate))
          .collect(Collectors.toList());

      List<DataforCache> dataforCaches = yahooStockEntities.stream()
          .map(e -> dataCacheMapper.map(e)).collect(Collectors.toList());

      Data005forRedis data005forRedis = new Data005forRedis(dataforCaches);
      String json = objectMapper.writeValueAsString(data005forRedis);

      redisTemplate.opsForValue().set("5MIN-005.HK", json,Duration.ofMinutes(5));
      return data005forRedis;

    }

  }

  public void updateDailydata(){String key = keyService.hardCodeCrumb();

    RestTemplate r1 = new RestTemplate();
    String url388 = "https://query1.finance.yahoo.com/v7/finance/quote?symbols=0388.HK&crumb=" + key;

    String url700 = "https://query1.finance.yahoo.com/v7/finance/quote?symbols=0700.HK&crumb=" + key;
    String url005 = "https://query1.finance.yahoo.com/v7/finance/quote?symbols=0005.HK&crumb=" + key;

    HttpHeaders headers = new HttpHeaders();
    headers.set("Cookie", cookies);
    HttpEntity<Void> entity = new HttpEntity<>(headers);

    ResponseEntity<Stock> response1 = r1.exchange(url388, HttpMethod.GET, entity, Stock.class);
    ResponseEntity<Stock> response2 = r1.exchange(url700, HttpMethod.GET, entity, Stock.class);
    ResponseEntity<Stock> response3 = r1.exchange(url005, HttpMethod.GET, entity, Stock.class);

    YahooStockEntity yahooStockEntity388 = yahooStockEntityMapper.mapdaily(response1.getBody());
    YahooStockEntity yahooStockEntity700 = yahooStockEntityMapper.mapdaily(response2.getBody());
    YahooStockEntity yahooStockEntity005 = yahooStockEntityMapper.mapdaily(response3.getBody());

    yahooStockEntityRepository.save(yahooStockEntity388);
    yahooStockEntityRepository.save(yahooStockEntity700);
    yahooStockEntityRepository.save(yahooStockEntity005);

    redisTemplate.delete("5min");
    redisTemplate.delete("5MIN-0388.HK");
    redisTemplate.delete("5MIN-0388.HK");
    redisTemplate.delete("5MIN-0388.HK");

  }



  

}
