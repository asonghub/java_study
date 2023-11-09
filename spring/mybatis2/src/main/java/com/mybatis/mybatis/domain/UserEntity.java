package com.mybatis.mybatis.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.usertype.UserType;

@Entity // db테이블에 대응되는 하나의 클래스 , 기본생성자가 필요함
@Table(name = "user") //user테이블과 대응되도록 , 작성하지 않으면 userEntity로 생성됨)
@Getter
@Setter
@Builder // 생성자에 필드가 들어있음 사용하려면 아래 두개를 추가해야함
@NoArgsConstructor
@AllArgsConstructor

public class UserEntity {
    @Id //pk
    @GeneratedValue( strategy = GenerationType.IDENTITY) //auto_increment로 설정해라
    private int id;
    @Column(name = "name", nullable = false, length = 20)
    private String name;
    @Column
    private String nickname; // 255
//    @Column(columnDefinition = "text")
//    private String nickname2;

    //Enum타입을 만들 수 있다.
//    @Column
//    @Enumerated(EnumType.STRING) // ORDINARL ->실제 사용 권장안함
//    private UserType type;

    public enum UserType{
        STUDENT, TEACHER
    }

}
