package com.todoapp.models.dao;

import jakarta.persistence.*;

@Entity
@Table(name = "todos")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 100)
    private String title;
    private boolean isDone;

    public Todo() {
    }

    public Todo(String title, boolean isDone) {
        this.title = title;
        this.isDone = isDone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }
}
