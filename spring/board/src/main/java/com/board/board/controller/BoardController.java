package com.board.board.controller;

import com.board.board.dto.BoardDTO;
import com.board.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    //게시물 등록
    @GetMapping("/")
    public String getRegister(){
        return "board";
    }

    @PostMapping("/board")
    public boolean postRegister(@RequestBody BoardDTO boardDTO){

        boardService.addTitle(boardDTO);
        return true;
    }

}
