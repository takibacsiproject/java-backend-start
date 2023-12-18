package com.todoapp.services;

import com.todoapp.exceptions.NoSuchTodoException;
import com.todoapp.models.dto.NewTodo;
import com.todoapp.models.dao.Todo;
import com.todoapp.models.dto.UpdateTodo;

import java.util.List;

public interface TodoService {
    List<Todo> getTodos();

    Todo save(NewTodo todo);

   Todo update(Integer id, UpdateTodo update) throws NoSuchTodoException;

    void delete(Integer id) throws NoSuchTodoException;
}
