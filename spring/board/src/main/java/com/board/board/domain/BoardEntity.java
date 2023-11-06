package com.board.board.domain;

import jakarta.persistence.*;

@Entity
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(length = 255, nullable = false)
    private String name;
    @Column(length = 255, nullable = false)
    private String title;


    public BoardEntity() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
