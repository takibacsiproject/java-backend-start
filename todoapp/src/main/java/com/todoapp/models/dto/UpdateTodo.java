package com.todoapp.models.dto;

import lombok.Data;

@Data
public class UpdateTodo {
    private String title;
    private Boolean isDone;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getDone() {
        return isDone;
    }

    public void setDone(Boolean done) {
        isDone = done;
    }
}
