package com.kdtjava.KDT9.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

public class PracVO {
    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getBirth() {
        return birth;
    }

    public ArrayList<String> getHobbies() {
        return hobbies;
    }

    private String name;
    private String gender;
    private String birth;
    private ArrayList<String> hobbies;
}
