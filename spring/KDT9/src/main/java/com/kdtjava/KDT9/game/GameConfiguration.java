package com.kdtjava.KDT9.game;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class GameConfiguration {
//각 클래스에 컴포넌트를 추가해주면 이 파일을 사용하지 않아도 됨.
    //빈으로 하면 다 하나하나 넣어줘야하는데 컴포넌트 개꿀!
    /*
    @Bean // bean은 메소드에 넣는다.
    public  GameConsole diablo(){
        return new Diablo();
    }
    @Bean
    @Primary
    public  GameConsole MapleStory(){
        return new MapleStory();
    }

    @Bean
    public GameEngine gameEngine(GameConsole game){ //가져다 쓸 빈이 하나면 아무 이름이나 넣어도 댐
        return new GameEngine(game);
    }
     */
}
