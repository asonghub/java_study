package com.mybatis.mybatis.repository;

import com.mybatis.mybatis.domain.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Integer> {
    //select * from board ; List<Board>
    // 검색어가 있으면 title 일치 검색, 없으면 전체 검색
    @Query("select b from BoardEntity b where (b.title= :word or :word='')")
    // 확인해야 하는 조건 2개 (title이 일치하는가 or 검색어가 비어있는가)
    List<BoardEntity> getBoardByWord(@Param("word") String word);

}
