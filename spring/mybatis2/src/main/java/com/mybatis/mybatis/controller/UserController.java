package com.mybatis.mybatis.controller;

import com.mybatis.mybatis.domain.User;
import com.mybatis.mybatis.dto.UserDTO;
import com.mybatis.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {
    // 만드는 순서
    // 1) domain
    // 2) dto
    // 3) mapper
    // 4) service
    // 5) controller
    // UserService를 호출하고 그에 대한 결과를 받아와서 template로 전달해주는 역할

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String getUer(Model model) {
        List<UserDTO> users = userService.getUserList();
        model.addAttribute("list", users);
        return "user";
    }

    //get 방식으로 /user?name=이름&nickname=닉네임
    @GetMapping("/user")
    public String insertUser(@RequestParam String name, @RequestParam String nickname){
        userService.insertUser(name, nickname);
        return "user";
    }

    @PatchMapping("/edit")
    public String patchUser(@PathVariable Integer id,
                            @RequestBody UserDTO userDTO){
        userService.patchUser(id, userDTO);
        return "user";
    }

    @GetMapping("/search")
    @ResponseBody
    public String selectUser(@RequestParam String name){
        return  userService.searchUser(name);
    }

    @GetMapping("/searchid")
    @ResponseBody
    public String searchid(@RequestParam int id){
        return userService.searchId(id);
    }

    @GetMapping("/jpaInsert")
    @ResponseBody
    public String jpaInsert(@RequestParam String name, @RequestParam String nickname){
        return userService.jpaInsert(name, nickname);
    }

    @GetMapping("/searchName")
    @ResponseBody
    public int searchName(@RequestParam String name){
        return userService.searchName(name).size();
    }

    @GetMapping("/searchNameOrNick")
    @ResponseBody
    public int searchNameOrNick(@RequestParam String word){
        return userService.searchNameOrNick(word).size();
    }

    @GetMapping("/ispresent")
    @ResponseBody
    public String isNamePresent(@RequestParam String name){
        return userService.isNamePresent(name);
    }

}
