package com.mybatis.mybatis.controller;

import com.mybatis.mybatis.domain.Board;
import com.mybatis.mybatis.dto.BoardDTO;
import com.mybatis.mybatis.service.BoardService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BoardController {

    @Autowired
    BoardService boardService;

    @GetMapping("/board")
    public String getBoards(Model model){
        List<BoardDTO> list = boardService.getBoardAll();
        model.addAttribute("list", list);
        return "board";
    }
    @GetMapping("/board/search")
    @ResponseBody
    public int searchBoard(@RequestParam String word, Model model){
        List<BoardDTO> list = boardService.searchBoard(word);
        model.addAttribute("list", list);
//    list.size()
        return list.size();
    }

    @PostMapping("/board")
    @ResponseBody
    public void insertBoard(@RequestBody Board board){
        //게시글 작성
        boardService.insertBoard(board);
        //템플릿을 return해야하는데 void로 되어 있으면 axios 응답에 빈값을 보냄..
        //현재 템플릿을 다시 보여줌.

    }
    @PatchMapping("/board")
    public void patchBoard(@RequestBody BoardDTO boardDTO){
        boardService.patchBoard(boardDTO);
    }

    @DeleteMapping("/board")
    @ResponseBody
    public void deleteBoard(@RequestParam int id){
        boardService.deleteBoard(id);
    }
}
