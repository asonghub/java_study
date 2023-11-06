package com.crud.crudtest.repository;


import com.crud.crudtest.domain.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Long> {

    //name 매개변수를 받은 PersonEntity의 name필드와 비교
    //일치하는 레코드가 db에 있을떄 해당 엔티티를 Java의 Optional 객체로 반환
    // => Select * From PersonEntity WHERE name = :mame
    Optional<PersonEntity> findByName(String name);

    Optional<PersonEntity> findByUseridAndPassword(String userid, String password);

    PersonEntity findByUserid(String userid);

    @Modifying //쿼리 어노테이션과 같이 사용. 기본적으로 select문인데 다른걸 쓰려면 modifying어노테이션!
    @Query("DELETE FROM PersonEntity p where p.userid = :userid")
    void deleteByUserid(@Param("userid") String userid);



    //복잡한 쿼리일때 JPQL사용
//    @Query("SELECT * FROM seoul userid = :userid AND password = :password ORDER BY id DESC LIMIT 1")
//    Optional<PersonEntity> findByUseridAndPasswordOrderByIdDesc(@Param("userid") String userid, @Param("password") String password);




}
//Optional 클래스의 메서드
/**
 * 1. orElse()
 * 저장된 값이 있으면 그 값반환, 없으면 인자로 넘겨진 값 반환
 * ex) personRepository.orElse("저장된 값이 없습니다")
 *
 * 2. orElseThrow( ()=>{} )
 * 저장된 값이 있으면 그 값반환, 없으면 예외처리
 *
 * 3. isPresent() ( == isEmpty() java11버전 이상부터 사용 )
 * 값이 존재한 true, 없으면 false
 *
 * 4. filter()
 * 값이 존재하고 주어진 조건을 만족하면 그 값을 포함하는 Optional을 반환
 * 값이 없으면 빈 Optional반환
 *
 */

