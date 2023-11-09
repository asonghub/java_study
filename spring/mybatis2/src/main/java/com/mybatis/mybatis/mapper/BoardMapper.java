package com.mybatis.mybatis.mapper;

import com.mybatis.mybatis.domain.Board;
import com.mybatis.mybatis.dto.BoardDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<Board> getBoardAll(); // 전체 조회
    void insertBoard(Board board);// 삽입 (insert)
    void patchBoard(BoardDTO boardDTO); // 수정(update)

    void deleteBoard(int id); //삭제(delete)

    List<Board> searchBoard(String word); // 검색
}

// mapper에는 있지만, xml에는 없는 경우 -> 실행했을 때만 오류가
// xml에는 있지만 mapper에는 없는 경우 ->실행자체가 안된다.