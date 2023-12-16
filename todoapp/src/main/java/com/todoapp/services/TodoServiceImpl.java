package com.todoapp.services;

import com.todoapp.models.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {
    private List<Todo> todos;

    public TodoServiceImpl() {
        todos = new ArrayList<>();
        todos.add(new Todo("kutyat setaltatni", false));
        todos.add(new Todo("ebedet fozni", false));
        todos.add(new Todo("reggelizni", true));
    }
    @Override
    public List<Todo> getTodos() {
        return todos;
    }
}
