package com.kdtjava.KDT9.game;

import org.springframework.stereotype.Component;

@Component
public class GameEngine {
    private GameConsole game; //인터페이스를 사용하여 결합도 낮추기!

    public GameEngine(GameConsole game){
        this.game = game;
    }

    public void run(){
        game.up();
        game.down();
        game.right();
        game.left();
    }
}
