package com.mybatis.mybatis.service;

import com.mybatis.mybatis.domain.Board;
import com.mybatis.mybatis.domain.BoardEntity;
import com.mybatis.mybatis.dto.BoardDTO;
import com.mybatis.mybatis.mapper.BoardMapper;
import com.mybatis.mybatis.repository.BoardRepository;
import com.mybatis.mybatis.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService {
    @Autowired
    BoardMapper boardMapper;

    @Autowired
    BoardRepository boardRepository;



    // 1. 전체조회 List<BoardDTO>
    public List<BoardDTO> getBoardAll(){
        // mapper 실행
//        List<Board> result = boardMapper.getBoardAll();
        List<BoardEntity> result = boardRepository.findAll();
        List<BoardDTO> list = new ArrayList<>();

        // DateTime -> String
        // SimpleDateFormat(형식).format(dateTime데이터)
        for (BoardEntity board: result) {
            BoardDTO boardDTO = BoardDTO.builder()
                    .id(board.getId())
                    .title(board.getTitle())
                    .content(board.getContent())
                    .writer(board.getWriter())
                    //.registered(board.getRegistered()) //dto 에는 string, entity에는 datetime
                    .registered(new SimpleDateFormat("yyy-MM-dd hh:mm:ss").format(board.getRegistered()))
                    .no(board.getWriter() + board.getId())
                    .build();
            list.add(boardDTO);
        }
        return list;
    }

    public void insertBoard(Board board) {
        BoardEntity boardEntity = BoardEntity.builder()
                .writer(board.getWriter())
                .title(board.getTitle())
                .content(board.getContent())
                .build();
        boardRepository.save(boardEntity);
//        boardMapper.insertBoard(board);
    }

    public void patchBoard(BoardDTO boardDTO) {
        //검증
        BoardEntity boardEntity = boardRepository.findById(boardDTO.getId())
                .orElseThrow(()-> new RuntimeException("board patch id is wrong"));

        BoardEntity modified = BoardEntity.builder()
                .id(boardEntity.getId())
                .title(boardDTO.getTitle())
                .content(boardDTO.getContent())
                .writer(boardDTO.getWriter())
                .registered(boardEntity.getRegistered())
                //null을 허용하지 않은 데이터는 값을 무조건 넣어줘야 한다.
                .build();
        boardRepository.save(modified);
        //save(): insert 할때
        //save(): 새로운 entity를 insert 할 때 or 기존 entity를 update할 때 사용된다.
        // 기본값 (pk)의 상태에 따라 다르게 동작
        // - pk 값이 존재한ㄴ 경우 : pk와 연결된 entity update
        // - pk 값이 존재하지 않는 경우 : 새로운 entity를 insert


//        boardMapper.patchBoard(boardDTO);
        // mapper파일에서는 여러 개를 parametet로 받을 수 있는데
        // xml 파일은 하나밖에 못 받는다. (파라미터 타입을 하나밖에 지정 못해서)
    }

    public void deleteBoard(int id) {
        // repository의 delete 기본 메소드를 이ㅛㅇㅇ. delete(Entity)
        // 1) id를 이용해서 entity를 검색
        // 2) 검색된 entity를 delete에 보내야 삭제 완료
        BoardEntity boardEntity = boardRepository.findById(id)
                        .orElseThrow(()-> new RuntimeException("board delete id is wrong"));
        boardRepository.delete(boardEntity);
//        boardMapper.deleteBoard(id);
    }

    public List<BoardDTO> searchBoard(String word) {
        List<BoardEntity> result = boardRepository.getBoardByWord(word);
//        List<Board> result = boardMapper.searchBoard(word);
        System.out.println(result);
        List<BoardDTO> list = new ArrayList<>();
        for (BoardEntity board: result) {
            BoardDTO boardDTO = BoardDTO.builder()
                    .id(board.getId())
                    .title(board.getTitle())
                    .content(board.getContent())
                    .writer(board.getWriter())
                    .registered((new SimpleDateFormat("yyy-MM-dd hh:mm:ss").format(board.getRegistered()))
                    .no(board.getWriter() + board.getId())
                    .build();
            list.add(boardDTO);
        }
        return list;
    }
}
