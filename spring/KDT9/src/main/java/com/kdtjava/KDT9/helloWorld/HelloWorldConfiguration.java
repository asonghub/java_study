package com.kdtjava.KDT9.helloWorld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

//record: getter, setter , 생성자등을  자동으로 만들어줌!
record Person(String name, int age){}
//name, age 는 private가 됨(???)

record Address(String address, int postCode){}

record  Infomation(String name, int age, Address address){}

//Configuration: 빈(Bean) 정의를 포함하는 클래스
@Configuration

public class HelloWorldConfiguration {

    @Bean
    public String name(){
        return "KDT9";
    }

    @Bean
    public int age(){
        return 28;
    }

    @Bean
    public Person person(){
        return new Person("Tom", 23);
    }

    @Bean
    public Person person2(){
        return new Person(name(), age()); //정의한 빈을 재사용 할 수 있음.
    }

    @Bean(name = "myAddress")
    public Address address(){
        return new Address("서울시 관악구",1234);
    }

    @Bean
    @Primary
    // 메소드의 이름만 써도됨..!
    public Infomation info(String name, int age, Address address){
        return new Infomation(name, age, address);
    }

    @Bean
    @Primary //레코드가 두개 이상인경우 레코드.class 로했을때 얘를 읽도록!
    public Address address2(){
        return new Address("Seoul Primary", 12121);
    }

    @Bean
    @Qualifier("addressQualifier") //한정자
    public Address address3(){
        return new Address("서대문", 33333);
    }

    @Bean
    public Infomation info2(String name, int age, @Qualifier("addressQualifier") Address addr){
        return new Infomation(name, age, addr);
    }
}
