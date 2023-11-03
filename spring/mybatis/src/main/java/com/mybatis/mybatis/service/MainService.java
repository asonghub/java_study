package com.mybatis.mybatis.service;

import com.mybatis.mybatis.domain.MyUsers;
import com.mybatis.mybatis.domain.Users;
import com.mybatis.mybatis.dto.MyUserDTO;
import com.mybatis.mybatis.dto.UserDTO;
import com.mybatis.mybatis.mapper.MainMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MainService {
    //XML 주입 - SQL쿼리와 Java 객체간의 매핑 정의
    @Autowired
    private MainMapper mainMapper;

    //여기서 DTO를 사용하는 이유는
    public List<UserDTO> getUserList(){

        //실제 데이터베이스에서 가져오는 Users배열
        List<Users> result = mainMapper.findAll();

        //위에서 받은 Users배열을 UserDTO배열로 반환하기
        //select all 이여서 배열로 오니까 반복문으로 하나씩 넣어줘야함.
        List<UserDTO> users = new ArrayList<>();
        for (Users value : result) {
            UserDTO user = new UserDTO();
            user.setId(value.getId());
            user.setName(value.getName());
            user.setAddress(value.getAddress());

            users.add(user);
        }

        return users;
    }

    //간접적으로 접근하기 위해서 DTO를 사용해야함.
    //도메인(모델)에서 바로 서비스로 접근 지양

    //여긴 Users 대신 UserDTO써야함
    public void addUser(Users user){
        mainMapper.insertUser(user);
    }


    //////////////////////////////////실습

    //회원가입
    public  void signin(MyUsers user){
        mainMapper.signin(user);
    }

    //로그인
    public MyUserDTO findUser(String userid, String password){
        return  mainMapper.findUser(userid, password);
    }


}
