package com.kdtjava.KDT9.game;

import org.springframework.stereotype.Component;

@Component
public class Diablo implements GameConsole {

    public void up(){
        System.out.println("Diablo up");
    }

    public void down(){
        System.out.println("Diablo down");
    }

    public void right(){
        System.out.println("Diablo right");
    }

    public void left(){
        System.out.println("Diablo left");
    }
}
