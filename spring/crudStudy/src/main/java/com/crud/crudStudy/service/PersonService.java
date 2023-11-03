package com.crud.crudStudy.service;

import com.crud.crudStudy.domain.Person;
import com.crud.crudStudy.dto.PersonDTO;
import com.crud.crudStudy.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class PersonService {

    @Autowired
    private PersonMapper personMapper;

    public void insertPerson(PersonDTO personDTO){

    }

    //로그인
    public PersonDTO getPerson(PersonDTO personDTO){
        Person person = personMapper.getPerson(personDTO.getUser_id(),personDTO.getPassword());
        return person;
    }
}
