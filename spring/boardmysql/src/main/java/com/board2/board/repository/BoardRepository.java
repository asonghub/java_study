package com.board2.board.repository;

import com.board2.board.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Integer> {
    //저장, 조회, 삭제는 있음. 커스터마이즹 할거만 쓰면됨

//    List<BoardEntity> findByAuthor(String author);
    BoardEntity findByAuthor(String author);
}
