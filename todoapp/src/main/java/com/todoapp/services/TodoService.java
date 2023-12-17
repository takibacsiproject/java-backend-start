package com.todoapp.services;

import com.todoapp.models.NewTodo;
import com.todoapp.models.Todo;

import java.util.List;

public interface TodoService {
    List<Todo> getTodos();

    Todo save(NewTodo todo);
}
