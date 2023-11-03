package com.kdtjava.KDT9.controller;

import com.kdtjava.KDT9.dto.UserDTO;
import com.kdtjava.KDT9.vo.PracVO;
import com.kdtjava.KDT9.vo.UserVO;
import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

@Controller
//@RestController :
public class MainController {
    @GetMapping("/")
    public String getMain(){
        return "request";
    }

    @GetMapping("/get/response1")
    // ?key=value
    // /get/response1?name=abc
    // 기본 값으로 required=true 를 갖기 때문에 ?name= 을 필수로 보내 줘야 한다.
public  String getResponse1(@RequestParam(value = "name") String n, Model model){
    model.addAttribute("name", n);
    return "response";
}
    @GetMapping("/get/response2")
    //required false 여서 /get/response2 로 연결 해도 실행됨!
    public  String getResponse2(@RequestParam(value = "name", required = false) String n, Model model){
        model.addAttribute("name", n);
        return "response";
    }

    @GetMapping("/get/response3/{name}/{age}")
    //경로에 있는 변수를 가져올 때  @PathVariable을 사용
    public String getResponse3(@PathVariable String name, @PathVariable("age") String abc, Model model){
        model.addAttribute("name", name);
        model.addAttribute("age",abc);
        return "response";
    }

    @GetMapping({"/get/response4/{name}/{age}", "/get/response4/{name}"})
    //@PathVariable 도 @RequestParam 과 동일하게 required 의 기본 값이 true
    //age 에만 false해놔도 url에서 걸리기 때문에 에러남
    // 하나의 getmapping에 url두개를 설정할 수 있음.
    public String getResponse4(@PathVariable String name, @PathVariable(required = false) String age, Model model){
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        return "response";
    }

    @GetMapping("/introduce/{name}")
    public String getPrac1(@PathVariable String name, Model model){
        model.addAttribute("name", name);
        return "prac";
    }

    @GetMapping("/introduce2")
    public String getPrac2(@RequestParam(value = "name")String n, @RequestParam(value = "age")Integer age, Model model){
        model.addAttribute("name", n);
        model.addAttribute("age", age);
        return "response";
    }

    @PostMapping("/post/response1")
    public String postResponse1(@RequestParam String name, Model model){
        //@RequestBody : 전달받은 Body 데이터를 json형태의 객체로 만들어준다.
        model.addAttribute("name", name);
        return "response";
    }
    @PostMapping("/post/response2")
    //검색 검색어는 필수 + 해시태그, 상세설정 선택
    // ?search=가
    // ?search=가&hashtag= 집
    public String postResponse2(@RequestParam(required = false) String name, Model model){
        //@RequestBody : 전달받은 Body 데이터를 json형태의 객체로 만들어준다.
        model.addAttribute("name", name);
        return "response";
    }
    @PostMapping("/post/response3")
    @ResponseBody
    //view를 랜더하는게 아니라 실제 값을 리턴해줌
    //response 데이터를 전달 //res.send
    public String postResponse3(@RequestParam(required = false) String name, Model model){
        //@RequestBody : 전달받은 Body 데이터를 json형태의 객체로 만들어준다.
        model.addAttribute("name", name);
        return "response";
    }


    @GetMapping("/post")
    public String getMain2(){
        return "pracRequest";
    }
    @PostMapping("/post/prac")
    public String postprac(@RequestParam String name, String gender, String birth, String hobby, Model model){
        model.addAttribute("name",name); //키값은 response에서 받는 이름, 뒤 name은 보내줄 값
        model.addAttribute("gender",gender);
        model.addAttribute("birth",birth);
        model.addAttribute("hobby",hobby);
        return "postprac";
    }

    @PostMapping("/post/body")
    public String postprac2(@RequestBody String[] arr,Model model){
        model.addAttribute("");
        return "postprac";
    }

    @GetMapping("/dto/response1")
    @ResponseBody
    public String dtoResponse1 (@ModelAttribute UserDTO userDTO){ //@ModelAttribute생략해도 잗동으로 붙음
        // DTO 앞에 어노테이션을 붙이지 않으면 -> @ModelAttribute가 자동으로 실행됨.
        // @ModelAttribute: html 폼 데이터를 컨트롤러로 전달할 때 객체에 매핑해줌
        // 일반 폼 형식으로 보내더라도 잘 받아서 매핑해줌

        // 매핑 -> 같은 이름끼리 set함수를 실행!
        // -> 프론트에서 {name, age} 를 보내서 실행 가능,
        // {name, age} -> setName, setAge 실행
        // -> {name, abc }를 보냈다면 age가 null이 될것.


        // @RequestBody 사용 가능? No!
        // 얘는 요청의 본문의 데이터를 받아서 넣어주지만.
        // requestbody는 데이터의 형식이 json 또는 xml이어야 함.
        // 일반 폼 전송 -> www-x-form-urlencoded 형식
        String msg = userDTO.getName() +" "+ userDTO.getAge();
        return msg;
    }

    @GetMapping("/dto/response11")
    @ResponseBody
    public String dtoResponse11(@RequestBody UserDTO userDTO){
        // Get 방식으로 전달하고 @RequestBody로 받으면 오류! (사실 일반폼전송이여서 오류)
        // @RequestBodys: 요청의 본문에 있는 데이터(body)
        String msg = userDTO.getName() +" "+ userDTO.getAge();
        return msg;
    }
    @PostMapping("/dto/response2")
    @ResponseBody
    public String dtoResponse2(@RequestBody UserDTO userDTO){
        // Get 방식으로 전달하고 @RequestBody로 받으면 오류! (사실 일반폼전송이여서 오류)
        // @RequestBodys: 요청의 본문에 있는 데이터(body)
        String msg = userDTO.getName() +" "+ userDTO.getAge();
        return msg;
    }

    // 일반 폼전송 - DTO
    // 1) 아무것도 적지 않고 DTO로 바로 받으면 -> ㅇ
    // 2) @ModelAttribute DTO 로 받으면 -> 0 1번과 동일
    // 3) @RequestBody DTO 로 받으면 -> 오류

    // @RequestBody 는 본문에 있는 데이터(body)를 받아서 객체에 매핑
    // 단, 전달받은 요청의 데이터 형식이 json 또는 xml 일 때만 실행이 가능
    // 일반 폼 전송 -> www-x-form-rulencoded


    @GetMapping("/vo/response1")
    @ResponseBody
    public String voResponse1(@ModelAttribute UserVO userVO){
        String msg = userVO.getName() +" "+ userVO.getAge();
        //vo는 set함수가 없어서 null null
        //modelAttribute 는 set함수를 이용해 값을 넣어주는구나!
        return msg;
    }

    @PostMapping("vo/response2")
    @ResponseBody
    public String voResponse2(@RequestBody UserDTO userDTO){
        String msg = userDTO.getName() +" "+ userDTO.getAge();
        return msg;
    }



    ////////////////////// dto axios get
    @GetMapping("/axios/response1")
    @ResponseBody
    public String axiosResponse1(@RequestParam String name, @RequestParam String age){
        // axios get 전송일 때, @RequestParam으로 값을 전달 받을 수 있다.
        String msg = "이름: "+ name + " 나이: " + age ;
        return msg;
    }

    @GetMapping("/axios/response2")
    @ResponseBody
    public String axiosResponse2(UserDTO userDTO){
        //axios get 전송일 때, @ModelAttribute으로 값을 전달받을 수 있다(=set함수가 있는 객체)
        String msg = "name: " + userDTO.getName() + " age: " + userDTO.getAge();
        return msg;
    }

    /////////post

    // ModelAttribute 와 @RequestParam의 특징
    // 일반폼전송 -> 파라미터 형태로 들어옴.
    // get방식은 파라미터로 보내서 ㄱㅊ
    // post는 데이터 형태로 보냄
    // json으로 값을 보내면 (axios) 파라미터 x, 데이터 ㅇ (요청 본문 데이터)
    // 그래서 modelAttribute와 RequestParam이 못읽음
    @PostMapping("/axios/response3")
    @ResponseBody
    public String axiosResponse3(@RequestParam String name, @RequestParam String age){
        // axios post 는 @RequestParam으로 못받는다.
        String msg = "이름: "+ name + " 나이: " + age ;
        return msg;
    }

    @PostMapping("/axios/response4")
    @ResponseBody
    public  String axiosResponse4(UserDTO userDTO){
        //
        String msg = "name: " + userDTO.getName() + " age: " + userDTO.getAge();
        return msg;
    }

    @PostMapping("/axios/response5")
    @ResponseBody
    public String axiosResponse5(@RequestBody UserDTO userDTO){
        //
        String msg = "name: " + userDTO.getName() + " age: " + userDTO.getAge();
        return msg;
    }

    @GetMapping("/axios/vo/response2")
    @ResponseBody
    public String axiosVoResponse2(UserVO userVO){
        String msg = "name: " + userVO.getName() + " age: " + userVO.getAge();
        return msg;
    }

    @PostMapping("/axios/vo/response4")
    @ResponseBody
    public String axiosVoResponse4(UserVO userVO){
        String msg = "name: " + userVO.getName() + " age: " + userVO.getAge();
        return msg;
    }

    @PostMapping("/axios/vo/response5")
    @ResponseBody
    public String axiosVoResponse5(@RequestBody UserVO userVO){
        // ModelAttribute는 setter 함수를 실행해 값을 넣어줌.
        // requestbody는 사용자가 만든 set함수를 실행하는것이 아니고
        // 각각의 field에 직접 주입함...!
        String msg = "name: " + userVO.getName() + " age: " + userVO.getAge();
        return msg;
    }


    //////////prac
    @PostMapping("/prac/vo")
    @ResponseBody
    public String pracVo(@RequestBody PracVO pracVO){
        System.out.println(pracVO.getHobbies());
        ArrayList<String> arr = new ArrayList<>(pracVO.getHobbies());
        String hobbies ="" ;
        for(String a : arr){
            hobbies += a + " ";
        }
        String msg = pracVO.getName() +" " +pracVO.getBirth() + " " + pracVO.getGender()+ " " + hobbies;
        return msg;
    }
}
