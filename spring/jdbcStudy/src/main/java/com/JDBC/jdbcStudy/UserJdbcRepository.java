package com.JDBC.jdbcStudy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserJdbcRepository {

    //어노테이션
    /**
     * @Component에서 파생되어 나온 어노테이션
     *
     * @Repository: 데이터 계층 컴포넌트
     * 특징: 데이터베이스에서 연산해서 발생할 수 있는 예외를
     * Spring의 'DataAccessException'으로 변하는 기능이 포함됨.
     *
     * @Service: 서비스 계층 컴포넌트, 비즈니스로직을 담당하는 클래스에 사용
     *
     * @Controller: 주로 어플리케이션에서 MVC패턴의 컨트롤러 역할을 담당.
     * 이 어노테이션을 사용한 클래스는 클라이언트의 요청을 받아 처리하고 응답을 반환함.
     * @RestController: @Controller와 유사하지만 Restfull 웹 서비스에서 사용.
     *
     * ========================================
     * @Autowired
     * 이 어노테이션을 사용하면 Spring 컨테이너가 자동으로 해당 타입의 Bean을 해당 필드나 메서드에 주입
     * 1. 필드 주입: 필드에 직접 사용하면 Spring이 해당 타입의 Bean을 찾아 자동으로 필드에 주입
     * 장점: 코드가 간결해진다. 단점: 의존성을 변경하거나 테스트에 어려움이 생길 수 있다.
     *
     * 2. 생성자 주입: 생성자에 주입하면 Spring이 생성자의 파라미터 타입에 맞는 빈을 찾아 주입
     * - 불변성(객체의 상태가 생성된 후 변경되지 않음)을 보장. 필요한 의존성이 명확하게 표시
     *
     * 3. 메서드 주입: Setter 메서드나 임의의 메서드에 사용하여 해당 메서드의 파라미터 타입에 맞는 빈을 찾아 주입
     *
     * @Autowired vs new
     * 공통점: 모두 객체를 생성하고 참조하는데 사용
     * 차이점:
     * - @Autowired: 스프링의 IoC컨테이너를 통해 의존성 주입을 사용.
     *  어노테이션이 붙는 필드나 생성자는 스프링이 자동으로 해당 타입의 빈을 찾아주입
     *
     * -new: 개발자가 명시적으로 객체를 생성하고 주입.
     */

    @Autowired
    //의존성주입을 할때 autowired를 써줌.  new jdbc어쩌고 할필요 없이
    private JdbcTemplate jdbc; //필드주입

    private static String INSERT_USER =
            """
            INSERT INTO users (id, name, address) VALUES (?,?,?);
            """;

    private static String DELETE_USER =
            """
            DELETE FROM users WHERE id = ?;        
            """;

    private static String SELECT_USER =
            """
            SELECT * FROM users WHERE id = ?; 
            """;
    public void insert(Users user){
        jdbc.update(INSERT_USER, user.getId(), user.getName(), user.getAddress());
        //sql문의 업데이트와 다름.
    }

    public void deleteId(long id){
        jdbc.update(DELETE_USER, id);
    }

    public Users findId(long id){
        //queryForObect: 주어진 쿼리에 따라 데이터베이스에서 한 행만 반환될 때 사용
        //Users클래스의 인스턴스로 매핑하기 위해서 new new BeanPropertyRowMapper<>(Users.clasS)<>(Users.class)
        //BeanPropertyRowMapper: 데이터베이스 테이블의 칼럼 이름과 java bean의 프로퍼티 이름을 자동으로 매핑
        return jdbc.queryForObject(SELECT_USER, new BeanPropertyRowMapper<>(Users.class),id);
    }
}

//JDBC 주요 매서드
//update(): INSERT, UPDATE, DELETE 와 같은 SQL문 실행
//query(): 여러행을 반환하는 쿼리 결과 처리할 때 사용
//execute(): 반환값이 없는 SQL명령을 실행
//queryForMap(): 단 하나의 행만 반환, 해당 데이터를 Map형태로 반환
//queryForInt: 단일 값 반환. 반환 값으로 int 형태 데이터.(select count(*) from emp)