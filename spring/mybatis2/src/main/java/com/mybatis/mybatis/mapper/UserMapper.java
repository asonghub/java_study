package com.mybatis.mybatis.mapper;

import com.mybatis.mybatis.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserMapper {


    // xml파일을 참고해서 id=retrieveAll의 sql문을 실행
    List<User> retrieveAll();

    //xml파일을 참고하지 않고 sql을 직접 (interface 에서)
    @Insert("insert into user(name, nickname) values(#{name}, #{nickname})")
    void insertUser(User user);

    // void insertUser(String name, String nickname) 도 동일
    // 객체를 전달하면 필드를 알아서 찾아서 넣어주고
    // 변수를 전달하면 맞춰서 넣어줌.
//    @Select("select * from user where id=#{id}")
//    User findUser(Integer id);

    @Update("update user set name=#{name}, nickname=#{nickname} where id=#{id}")
    void patchUser(User user);


}
