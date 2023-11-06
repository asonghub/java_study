package com.board2.board;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoardApplication.class, args);
	}

}


// 프로젝트 만들기 흐름
// 설정 -> Entity(DTO) -> Repository
// ->Service -> 컨트롤러