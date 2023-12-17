package com.todoapp.services;

import com.todoapp.models.dto.NewTodo;
import com.todoapp.models.dao.Todo;

import java.util.List;

public interface TodoService {
    List<Todo> getTodos();

    Todo save(NewTodo todo);
}
