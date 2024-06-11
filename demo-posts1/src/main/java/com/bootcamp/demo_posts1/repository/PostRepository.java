package com.bootcamp.demo_posts1.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bootcamp.demo_posts1.postEntity.PostEntity;

@Repository
public interface PostRepository extends JpaRepository<PostEntity,String> {

  Optional<List<PostEntity>> findByBodyContaining(String body );
  Optional<List<PostEntity>> findByBodyLike(String body );

//jpql -> work with entity // CAST(e.XXX as double)>:1000

  @Query(value = "select e from PostEntity e where e.userId>:2")
  Optional<List<PostEntity>> findByUserId(@Param(value = "100")Long number);
  
  @Modifying
  @Query(value = "update PostEntity e set e.BODY=: newbody where e.id=userid ")
  void updatePostBody(@Param("userId") String id
  ,@Param("newbody") String body);


  
}
