package com.JDBC.jdbcStudy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//controller, service, repository 아닌 경우엔 component
@Component
public class UserCommandRun implements CommandLineRunner {

    @Autowired
    private UserJdbcRepository user;
    @Override
    public void run(String... args) throws Exception {
        user.insert(new Users(1,"asong","관악구"));
        user.insert(new Users(2,"마","용산구"));
        user.insert(new Users(3,"아송","서대문구"));

        user.deleteId(1);

        System.out.println(user.findId(2));
        System.out.println(user.findId(3));
    }
}
