package com.board2.board.service;

import com.board2.board.dto.BoardDTO;
import com.board2.board.entity.BoardEntity;
import com.board2.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

    //게시판 글 작성
    public boolean createPost(BoardDTO boardDTO){
        BoardEntity board = new BoardEntity();

        board.setTitle(boardDTO.getTitle());
        board.setContent(boardDTO.getContent());
        board.setAuthor(boardDTO.getAuthor());

        boardRepository.save(board);

        return true;
    }

    public List<BoardDTO> findAllBoard() {
        List<BoardEntity> allBoard = boardRepository.findAll();
        List<BoardDTO> boards = new ArrayList<>();

        for (BoardEntity entity : allBoard) {
            BoardDTO boardDTO = new BoardDTO();

            boardDTO.setId(entity.getId());
            boardDTO.setTitle(entity.getTitle());
            boardDTO.setContent(entity.getContent());
            boardDTO.setAuthor(entity.getAuthor());

            boards.add(boardDTO);
        }
        return boards;
    }

    public boolean updateBoard(BoardDTO boardDTO) {
        // null 값이 있을수도 있을 땐 optional을 사용해줘야함
        Optional<BoardEntity> board = boardRepository.findById(boardDTO.getId());
        if(board.isPresent()){ //존재할때
            BoardEntity data = board.get();// board에 담은 데이터 가져오기
            data.setTitle(boardDTO.getTitle());
            data.setContent(boardDTO.getContent());
            data.setAuthor(boardDTO.getAuthor());

            boardRepository.save(data);
        }
        return true;

    }

    public boolean deleteBoard(BoardDTO boardDTO) {
        boardRepository.deleteById(boardDTO.getId());
        return true;
    }
}
