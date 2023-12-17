package com.todoapp.services;

import com.todoapp.models.dto.NewTodo;
import com.todoapp.models.dao.Todo;
import com.todoapp.repositories.TodoRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {
    private TodoRepository todoRepository;

    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }
    @Override
    public List<Todo> getTodos() {
        return todoRepository.findAll();
    }

    @Override
    public Todo save(NewTodo newTodo) {
        Todo todo = new Todo(newTodo.getTitle(), false);
        return todoRepository.save(todo);
    }
}
