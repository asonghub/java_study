package com.kdtjava.KDT9.dto;

import lombok.Getter;
import lombok.Setter;

// @Getter
// @Setter
// 클래스 위에 적으면 클래스의 모든 변수의 게터 세터 만듬.

// DTO는 개념임.
public class UserDTO {
    //getter와 setter를 만들자.
    // Generate > Getter and Setter
    // lombok (코드 다이어터) @Getter, @Setter

    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    private String age;
    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    //    @Getter
//    @Setter


}
