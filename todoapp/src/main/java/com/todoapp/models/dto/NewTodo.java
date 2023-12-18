package com.todoapp.models.dto;

import lombok.Data;

@Data
public class NewTodo {
    private String title;

    public String getTitle() {
        return title;
    }
}
