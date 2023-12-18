package com.todoapp.services;

import com.todoapp.exceptions.NoSuchTodoException;
import com.todoapp.models.dto.NewTodo;
import com.todoapp.models.dao.Todo;
import com.todoapp.models.dto.UpdateTodo;

import java.util.List;
import java.util.Optional;

public interface TodoService {
    List<Todo> getTodos();

    List<Todo> getTodos(Optional<Boolean> isDone, Optional<String> q);

    Todo getById(Integer id) throws NoSuchTodoException;

    Todo save(NewTodo todo);

   Todo update(Integer id, UpdateTodo update) throws NoSuchTodoException;

    void delete(Integer id) throws NoSuchTodoException;


}
