package com.kdtjava.KDT9.game;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class MapleStory implements GameConsole {

    public void up(){
        System.out.println("Maple up");
    }

    public void down(){
        System.out.println("Maple down");
    }

    public void right(){
        System.out.println("Maple right");
    }

    public void left(){
        System.out.println("Maple left");
    }
}
