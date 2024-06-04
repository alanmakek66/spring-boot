package com.bootcamp.demo_restful.reposityory;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.bootcamp.demo_restful.Dto.requestDto.UserRequestDto;
import com.bootcamp.demo_restful.UserEntitys.UserEntity;
import com.bootcamp.demo_restful.infa.NotFoundException;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long>{
  Optional<List<UserEntity>> findByPhone(String phone);
  Optional<List<UserEntity>> findByAddrLatAndAddrLong(String addrLat,String addrLong);

  //Optional<UserEntity> updateEmailByid(Long id, UserRequestDto dat);
  // like, //order by
  
}
