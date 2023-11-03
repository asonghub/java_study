package com.crud.crudtest.service;


import com.crud.crudtest.domain.Person;
import com.crud.crudtest.domain.PersonEntity;
import com.crud.crudtest.dto.PersonDTO;
import com.crud.crudtest.mapper.PersonMapper;
import com.crud.crudtest.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonMapper personMapper;

    @Autowired
    private PersonRepository personRepository;

    public void insertPerson(PersonDTO personDTO) {
        /*
        Person person = new Person();

        person.setUser_id( personDTO.getUser_id() );
        person.setPassword( personDTO.getPassword() );
        person.setName( personDTO.getName() );



        personMapper.insertPerson(person);

         */
        PersonEntity person = new PersonEntity();
        person.setUser_id( personDTO.getUser_id() );
        person.setPassword( personDTO.getPassword() );
        person.setName( personDTO.getName() );


        personRepository.save(person);

    }
    //로그인
    public PersonDTO getPerson(PersonDTO personDTO) {

        Optional<PersonEntity> person = personRepository.findByUserIdAndPassword(personDTO.getUserId(), personDTO.getPassword());
        PersonDTO data = new PersonDTO();
        data.setId(person.get().getId() );

        /*

        Person person = personMapper.getPerson(personDTO.getUser_id(), personDTO.getPassword());

        PersonDTO data = new PersonDTO();
        data.setId( person.getId() );
*/
        return data;
    }

    //회원정보 조회
    public PersonDTO getPersonData(long id) {
        /*
        Person person = personMapper.getPersonData(id);
        PersonDTO data = new PersonDTO();
        data.setUser_id( person.getUser_id() );
        data.setName( person.getName());
        data.setPassword( person.getPassword());
         */

        Optional<PersonEntity> person = personRepository.findById(id);
        PersonDTO data = new PersonDTO();

        if(person.isPresent()){
            System.out.println("값이 존재하지 않습니다");
        }else {

            data.setUserId(person.get().getUserId() );
            data.setName( person.get().getName());
            data.setPassword( person.get().getPassword());

        }

        return data;
    }

    //회원정보 수정
    public  void updatePerson(PersonDTO personDTO) {

        Person person = new Person();

        person.setName( personDTO.getName() );
        person.setPassword( personDTO.getPassword() );
        person.setUser_id( personDTO.getUserId() );

        personMapper.updatePerson(person);

    }


    //회원정보 삭제
    public  void deletePerson(PersonDTO personDTO) {
        personMapper.deletePerson(personDTO.getUserId());
    }
}
