package com.boardSystem.board.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@Builder
public class Board2 {
    private int id;
    private String title;
    private String content;
    private String writer;
    private Timestamp registered;
}
