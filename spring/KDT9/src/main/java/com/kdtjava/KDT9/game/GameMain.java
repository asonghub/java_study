package com.kdtjava.KDT9.game;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration //메인으로 오는 걸 설정으로 넣는다 (???)
@ComponentScan("com.kdtjava.KDT9.game") // 참조할 페키지를 써준다
public class GameMain {
    public static void main(String[] args) {
//        var context = new AnnotationConfigApplicationContext(GameConfiguration.class);
        var context = new AnnotationConfigApplicationContext(GameMain.class);


        //결합도: 무엇인가를 변경하는데 얼마나 많은 작업이 관련되어 있는지에 대한측정
        /*
        MapleStory game = new MapleStory();
        GameEngine engine = new GameEngine(game); //의존성 주입. 게임엔진은 게임이 있어야 가능!
        engine.run();

        Diablo game2 = new Diablo();
        GameEngine engine2 = new GameEngine(game2);
        */

        context.getBean(GameConsole.class).up();
        context.getBean(GameEngine.class).run();
    }
}
