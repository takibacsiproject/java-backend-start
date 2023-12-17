package com.todoapp.models;

public class Todo {

    private Integer id;
    private String title;
    private boolean isDone;

    public Todo(Integer id, String title, boolean isDone) {
        this.id = id;
        this.title = title;
        this.isDone = isDone;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
