package com.mybatis.mybatis.repository;

import com.mybatis.mybatis.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> { //<관리하고자 하는 엔티티, pk타입>

    List<UserEntity> findByName(String name);

    Optional<UserEntity> findById(int id); //pk니까 하나로만 반환됨.

//    @Query(nativeQuery = true, value = "select * from user where name = :nickname || nickname= :nickname")
    List<UserEntity> findByNameOrNickname(String name, String nickname);

    boolean existsByName(String name);
    // optional이라는 wrapper클래스로 감싸서 줌! null일 경우를 대비해서

//    @Query("select *  from user where name = :name")
//    UserEntity findNameByName(String name);

    // select * from user where name = {name}
//    @Query("select ue from UserEntity ue where ue.name = :name")
//    @Query(nativeQuery = true, value = "select * from user where name=:name")
//    UserEntity findNameByName(String name);


}
