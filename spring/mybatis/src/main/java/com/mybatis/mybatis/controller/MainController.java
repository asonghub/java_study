package com.mybatis.mybatis.controller;

import com.mybatis.mybatis.domain.MyUsers;
import com.mybatis.mybatis.domain.Users;
import com.mybatis.mybatis.dto.MyUserDTO;
import com.mybatis.mybatis.dto.UserDTO;
import com.mybatis.mybatis.service.MainService;
import jdk.jshell.Snippet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


//컨트롤러 :서비스를 가져다 씀
// xml -> 인터페이스 매퍼 -> 서비스 -> 컨트롤러
@Controller
public class MainController {

    @Autowired
    private MainService mainService;

    @GetMapping("/users")
    public String getUsers(Model model){
        List<UserDTO> userList =  mainService.getUserList();
        model.addAttribute("list",userList);
        return "user";
    }

    @GetMapping("/user/insert")
    public String getInsertUser(@RequestParam String name, @RequestParam String address, Model model){
        Users user = new Users();
        user.setName(name);
        user.setAddress(address);

        mainService.addUser(user);

        model.addAttribute("list", null);
        return "user";
    }

    ////////////로그인

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    public String postlogin(@ModelAttribute MyUserDTO user, Model model){
//        MyUsers myuser = new MyUsers();
//        myuser.setUserid(user.getUserid());
//        myuser.setPassword(user.getPassword());
        String userid = user.getUserid();
        String password = user.getPassword();



        MyUserDTO userdto = mainService.findUser(userid, password);

        model.addAttribute("name", userdto.getName());
        model.addAttribute("userid", userdto.getUserid());
        model.addAttribute("password", userdto.getPassword());
        return "mypage";
    }

    //////////////회원가입
    @GetMapping("/signin")
    public String signin(){
        return "signin";
    }

    @PostMapping("/signin")
    public String postSignin(@ModelAttribute MyUserDTO user, Model model){
        System.out.println(user.getUserid() + user.getName() + user.getPassword());
        MyUsers newuser = new MyUsers();
        newuser.setName(user.getName());
        newuser.setUserid(user.getUserid());
        newuser.setPassword(user.getPassword());

        mainService.signin(newuser);

        model.addAttribute("name", user.getName());
        model.addAttribute("userid", user.getUserid());
        model.addAttribute("password", user.getPassword());
        return "mypage";
    }

    @GetMapping
    public String mypage(@RequestParam(value = "userid")String userid){

        return "mypage";
    }

    @PostMapping("/edit")
    public String mypageEdit(@ModelAttribute MyUserDTO user, Model model){
        System.out.println(user.getUserid() + user.getName() + user.getPassword());
        MyUsers newuser = new MyUsers();
        newuser.setName(user.getName());
        newuser.setUserid(user.getUserid());
        newuser.setPassword(user.getPassword());

        mainService.edit(newuser);

        model.addAttribute("name", user.getName());
        model.addAttribute("userid", user.getUserid());
        model.addAttribute("password", user.getPassword());
        return "mypage";
    }


}
