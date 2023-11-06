package com.board.board.service;

import com.board.board.domain.BoardEntity;
import com.board.board.dto.BoardDTO;
import com.board.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    @Autowired
    BoardRepository boardRepository;

    //게시물 추가
    public void addTitle(BoardDTO boardDTO){
        BoardEntity board = new BoardEntity();

        board.setName(boardDTO.getName());
        board.setTitle(boardDTO.getTitle());

        boardRepository.save(board);
    }

    public void edit(BoardDTO boardDTO){
        BoardEntity board = boardRepository.findById(boardDTO.getId());

        board.setName(boardDTO.getName());
        board.setTitle(boardDTO.getTitle());

    }
}
