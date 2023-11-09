package com.boardSystem.board.mapper;

import com.boardSystem.board.domain.Board2;
import com.boardSystem.board.dto.Board2DTO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BoardMapper {
    @Select("select * from board2")
    List<Board2> getBoardList();

    @Insert("insert into board2(title, content, writer) values(#{title}, #{content}, #{writer})")
    void addBoard(Board2 board2);

    @Update("update board2 set title=#{title}, content=#{content}, writer=#{writer} where id=#{id}")
    void patchBoard(Board2 board2);

    @Delete("delete from board2 where id=#{id}")
    void deleteBoard(int id);

    List<Board2> customSelect(String writer);
}
