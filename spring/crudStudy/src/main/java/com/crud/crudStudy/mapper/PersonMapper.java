package com.crud.crudStudy.mapper;

import com.crud.crudStudy.domain.Person;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface PersonMapper {

    @Insert( "INSERT INTO person (user_id, password, name) VALUES (#{user_id}, #{password}), #{name}")
    void insertPerson(Person person);

    @Select("SELECT * FROM person WHERE (user_id=#{user_id} and password=#{password}")
    Person getPerson(String user_id, String password);
}
