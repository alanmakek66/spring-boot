package com.bootcamp.demo_restful.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bootcamp.demo_restful.Dto.requestDto.UserRequestDto;
import com.bootcamp.demo_restful.UserEntitys.UserEntity;
import com.bootcamp.demo_restful.UserEntitys.UserEntityDto;

import com.bootcamp.demo_restful.UserEntitys.Mapper.UserEntityDtoMapper;
import com.bootcamp.demo_restful.infa.NotFoundException;
import com.bootcamp.demo_restful.infa.Scheme;
import com.bootcamp.demo_restful.model.modelDto.User;
import com.bootcamp.demo_restful.reposityory.UserRepository;
import com.bootcamp.demo_restful.service.UserService;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class UserServiceImpl implements UserService {

  @Value(value = "${api.json-place-holder.domain}") // request = true;
  private String domain;

  @Value(value = "${api.json-place-holder.endpoints.users}")
  private String usersEndpoint;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private UserEntityDtoMapper uedm1;

  @Override
  public List<User> getUser() {
    // resttemplate
    /* String url= "https://jsonplaceholder.typicode.com/users"; */

    String url = UriComponentsBuilder.newInstance()
        .scheme(Scheme.HTTPS.name())
        .host(this.domain)
        .path(this.usersEndpoint)
        .toUriString();

    User[] u1 = new RestTemplate().getForObject(url, User[].class);
    // 1 call api and get json result
    // 2 convert json result to java object

    return Arrays.asList(u1);
  }

  @Override
  public UserEntity saveUserEntity(UserEntity u1) {
    return userRepository.save(u1);

  }

  @Override
  public List<UserEntity> saveApiToDataBase() {
    String url = "https://jsonplaceholder.typicode.com/users";
    User[] arru2 = new RestTemplate().getForObject(url, User[].class);
    List<User> uu = Arrays.asList(arru2);
    userRepository.saveAll(uu.stream().map(e -> uedm1.map(e)).collect(Collectors.toList()));
    return uu.stream().map(e -> uedm1.map(e)).collect(Collectors.toList());

  }

  @Override
  public UserEntity deletByid(Long id) throws NotFoundException {

    Optional<UserEntity> u1 = userRepository.findById(id);
    if (u1.isPresent()) {
      userRepository.deleteById(id);
      return u1.get();
    }
    throw new NotFoundException();

  }

  @Override
  public UserEntity update(Long id, UserEntity user) throws NotFoundException {

    UserEntity u1 = userRepository.findById(id)
        .orElseThrow(() -> new NotFoundException());

    u1.setName(user.getName());
    u1.setUsername(user.getUsername());
    u1.setEmail(user.getEmail());
    u1.setWebsite(user.getWebsite());
    u1.setAddrLat(user.getAddrLat());
    u1.setAddrStreet(user.getAddrStreet());
    u1.setAddrSuite(user.getAddrSuite());
    u1.setAddrcity(user.getAddrcity());
    u1.setAddrzipcode(user.getAddrzipcode());
    u1.setAddrLong(user.getAddrLong());
    u1.setCompanyName(user.getCompanyName());
    u1.setCompanycatchPhrase(user.getCompanycatchPhrase());
    u1.setCompanyBs(user.getCompanyBs());

    userRepository.save(u1);

    return u1;
  }

  @Override
  public UserEntity getUserById(Long id) throws NotFoundException {

    return userRepository.findById(id).orElseThrow(() -> new NotFoundException());
  }
  @Override 
  public List<UserEntity> getUserByPhone(String phone) throws NotFoundException{
    return userRepository.findByPhone(phone).orElseThrow(() -> new NotFoundException());
    
    
  }
  @Override
  public List<UserEntity> getUserByAddrLatAndaddrLong(String addrLat,String addrLong) throws NotFoundException{

    return userRepository.findByAddrLatAndAddrLong(addrLat, addrLong).orElseThrow(() -> new NotFoundException());

  }
  @Override
  public UserEntity updateEmailById(Long id, UserRequestDto dto) {
    Optional<UserEntity> userEntity = userRepository.findById(id);
    if (userEntity.isPresent()) {
      UserEntity entity = userEntity.get();
      entity.setEmail(dto.getEmail());
      userRepository.save(entity); // similar to Map put
      
      return entity;
    }
    throw new NotFoundException();
  }

}
