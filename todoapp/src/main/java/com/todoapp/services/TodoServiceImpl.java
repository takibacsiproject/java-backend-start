package com.todoapp.services;

import com.todoapp.models.NewTodo;
import com.todoapp.models.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {
    private List<Todo> todos;

    public TodoServiceImpl() {
        todos = new ArrayList<>();
        todos.add(new Todo(1, "kutyat setaltatni", false));
        todos.add(new Todo(2, "ebedet fozni", false));
        todos.add(new Todo(3, "reggelizni", true));
    }
    @Override
    public List<Todo> getTodos() {
        return todos;
    }

    @Override
    public Todo save(NewTodo newTodo) {
        Todo todo = new Todo(todos.size() + 1, newTodo.getTitle(), false);
        todos.add(todo);
        return todo;
    }
}
