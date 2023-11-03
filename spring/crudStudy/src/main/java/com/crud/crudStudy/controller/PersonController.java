package com.crud.crudStudy.controller;

import com.crud.crudStudy.dto.PersonDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class PersonController {

    @GetMapping("/register")
    public String getRegister(){
        return "register";
    }

    @PostMapping("/register")
    public String postRegister(@RequestBody PersonDTO persondto){
        person
        getRegister()
    }
}