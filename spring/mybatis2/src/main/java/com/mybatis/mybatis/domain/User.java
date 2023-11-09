package com.mybatis.mybatis.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    //db의 필드와 동일하게
    private int id;
    private String name;
    private String nickname;


}
