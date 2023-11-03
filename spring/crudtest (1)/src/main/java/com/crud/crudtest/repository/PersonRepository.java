package com.crud.crudtest.repository;

import com.crud.crudtest.domain.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Long> {

    //name 매개변수를 받은 PersonEntity의 name필드와 비교
    //일치하는 레코드가 db에 있을때  해당 Entity를 Java의 Otional객체로 반환
    // => Select * From PersonEntity Where name = :name
    Optional<PersonEntity> findByName(String name);

    Optional<PersonEntity> findByUserIdAndPassword(String userId , String password);
}

//Optional 클래스의 메서드
/**
 * 1. orElse()
 * 저장된 값이 있으면 그 값 반환, 없으면 인자로 넘겨진 값 반환
 * ex) personRepository.orElse("저장된 값이 없습니다")
 *
 * 2. orElseThrow( Supplier<? extends X> </?>)
 * 저장된 값이 있으면 그 값 반환, 없으면 예외처리
 *
 * 3. ispresent() (==isEmpty() java11 버전 이상부터 사용
 * 값이 존재하면 true, 없으면 false
 *
 * 4. filter()
 * 값이 존재하고 주어진 조건을 만족하면 그 값을 포팜하는 Optional을 반환
 * 값이 없으면 빈 Optional반환
 */