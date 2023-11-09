package com.mybatis.mybatis.mapper;

import com.mybatis.mybatis.domain.MyUsers;
import com.mybatis.mybatis.domain.Users;
import com.mybatis.mybatis.dto.MyUserDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface MainMapper {

    //mapper 참고하기
    List<Users> findAll();

    //mapper xml 참고 안하기
    //요즘은 이걸 더 많이 씀.
    @Insert("INSERT INTO users(name, address) VALUES (#{name}, #{address})")
    void insertUser(Users user);



    //////////실습

    //회원가입
    @Insert("INSERT INTO myusers(name, userid, password) VALUES (#{name}, #{userid}, #{password})")
    void signin(MyUsers user);


    //로그인 (회원찾기)
    @Select("SELECT * FROM myusers WHERE userid=#{userid} AND password=#{password}")
    MyUserDTO findUser(String userid, String password);

//    @Update("UPDATE " )
}

//xmlv-매핑-> mapper 인터페이스 -> 서비스
