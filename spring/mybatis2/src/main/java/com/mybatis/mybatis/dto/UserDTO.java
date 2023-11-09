package com.mybatis.mybatis.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class UserDTO {
    private int id;
    private String name;
    private String nickname;
    private int no;
}
