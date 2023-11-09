package com.boardSystem.board.controller;

import com.boardSystem.board.dto.Board2DTO;
import com.boardSystem.board.service.BoardService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BoardController {

    @Autowired
    BoardService boardService;

    @GetMapping("/")
    public String getBoard(Model model){
        List<Board2DTO> boardList =  boardService.boardList();
        model.addAttribute("list", boardList);
        return "board";
    }

    @PostMapping("/add")
    @ResponseBody
    public String addBoard(@RequestBody Board2DTO board2DTO){
        boardService.addBoard(board2DTO);

        return "추가 성공";
    }

    @PatchMapping("/edit/{id}")
    @ResponseBody
    public String patchBoard(@PathVariable int id,
                             @RequestBody Board2DTO board2DTO){
        boardService.patchBoard(id, board2DTO);
        return "추가완료";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBoard(@PathVariable int id, Model model){
        boardService.deleteBoard(id);
        return "board";
    }

    @GetMapping("/custom")
    public String customSelect(@RequestParam String writer, Model model){
        List<Board2DTO> boardList = boardService.customSelect(writer);
        model.addAttribute("list", boardList);
        return "user";
    }
}
