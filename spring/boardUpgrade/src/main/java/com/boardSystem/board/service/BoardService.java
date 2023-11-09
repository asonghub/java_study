package com.boardSystem.board.service;

import com.boardSystem.board.domain.Board2;
import com.boardSystem.board.dto.Board2DTO;
import com.boardSystem.board.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService {

    @Autowired
    BoardMapper boardMapper;

    //전체 보드 조회
    public List<Board2DTO> boardList() {
        List<Board2> list = boardMapper.getBoardList();
        List<Board2DTO> boardList = new ArrayList<>();

        for (Board2 b: list) {
            Board2DTO board = Board2DTO.builder()
                    .id(b.getId())
                    .title(b.getTitle())
                    .content(b.getContent())
                    .writer(b.getWriter())
                    .registered(b.getRegistered())
                    .build();
            boardList.add(board);
        }

        return boardList;
    }


    //보드 추가
    public void addBoard(Board2DTO board2DTO) {
        Board2 board = Board2.builder()
                .title(board2DTO.getTitle())
                .content(board2DTO.getContent())
                .writer(board2DTO.getWriter())
                .build();
        boardMapper.addBoard(board);
    }

    public void patchBoard(int id, Board2DTO board2DTO) {
        System.out.println("update");

        Board2 board = Board2.builder()
                .id(id)
                .title(board2DTO.getTitle())
                .content(board2DTO.getContent())
                .writer(board2DTO.getWriter())
                .build();

//        boardMapper.patchBoard(id, board2DTO.getTitle(), board2DTO.getContent(), board2DTO.getWriter());
        boardMapper.patchBoard(board);
    }

    public void deleteBoard(int id) {
        boardMapper.deleteBoard(id);
    }


    public List<Board2DTO> customSelect(String writer) {
        List<Board2> list = boardMapper.customSelect(writer);
        List<Board2DTO> boardList = new ArrayList<>();

        for (Board2 b: list) {
            Board2DTO board = Board2DTO.builder()
                    .id(b.getId())
                    .title(b.getTitle())
                    .content(b.getContent())
                    .writer(b.getWriter())
                    .registered(b.getRegistered())
                    .build();
            boardList.add(board);
        }
        return boardList;
    }
}
