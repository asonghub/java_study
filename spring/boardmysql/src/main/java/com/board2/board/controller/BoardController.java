package com.board2.board.controller;

import com.board2.board.dto.BoardDTO;
import com.board2.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @PostMapping("/register")
    @ResponseBody
    public boolean postRegister(@RequestBody BoardDTO boardDTO){
        return boardService.createPost(boardDTO);
    }

    @GetMapping("/all")
    @ResponseBody
    public List<BoardDTO> getAllBoard(){
        return boardService.findAllBoard();
    }

    //수정
    @PatchMapping("/update")
    @ResponseBody
    public boolean patchUpdate(@RequestBody BoardDTO boardDTO){
        return boardService.updateBoard(boardDTO);
    }
    //삭제
    @DeleteMapping("/delete")
    @ResponseBody
    public boolean boardDelete(@RequestBody BoardDTO boardDTO){
        return boardService.deleteBoard(boardDTO);
    }

}
