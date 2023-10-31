package com.kdtjava.KDT9.helloWorld;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HelloWorld {
    public static void main(String[] arg){
        //스프링 컨텍스트를 실행하는 단계
        var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class); //의존성 주입

        //스프링 프레임워크가 관리하도록 설정
        //스프링에서 과닐하는 것은 무엇이든 Bean이 될 수 있다.

        //bean을 가져오는 방법 1. 메소드의 이름을 쓴다
        System.out.println(context.getBean("name"));
        System.out.println(context.getBean("age"));
        System.out.println(context.getBean("person"));
        System.out.println(context.getBean("person2"));
//        System.out.println(context.getBean("address")); //Bean에 따로 이름을 저장한 경우 기존 빈의 이름을 사용할 수 없음
        System.out.println(context.getBean("myAddress"));
        System.out.println(context.getBean("info"));
        System.out.println(context.getBean("address2"));

        //bean을 가져오는 방법 2.레코드.class
        System.out.println(context.getBean(Infomation.class));
        System.out.println(context.getBean(Address.class));

        System.out.println(context.getBean("info2"));

    }
}
