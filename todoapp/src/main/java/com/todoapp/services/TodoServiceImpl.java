package com.todoapp.services;

import com.todoapp.exceptions.NoSuchTodoException;
import com.todoapp.models.dto.NewTodo;
import com.todoapp.models.dao.Todo;
import com.todoapp.models.dto.UpdateTodo;
import com.todoapp.repositories.TodoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

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
    public List<Todo> getTodos(Optional<Boolean> isDone, Optional<String> q) {
        if(isDone.isEmpty() && q.isEmpty()) {
            return getTodos();
        } else if(isDone.isPresent() && q.isEmpty()) {
            return todoRepository.findAllByIsDone(isDone.get());
        } else if(q.isPresent() && isDone.isEmpty()) {
            return todoRepository.findAllByTitleContainsIgnoreCase(q.get().toLowerCase());
        } else {
            return todoRepository.findAllByIsDoneAndTitleContainsIgnoreCase(isDone.get(), q.get());
        }
    }

    @Override
    public Todo getById(Integer id) throws NoSuchTodoException {
        return todoRepository.findById(id).orElseThrow(NoSuchTodoException::new);
    }

    @Override
    public Todo save(NewTodo newTodo) {
        Todo todo = new Todo(newTodo.getTitle(), false);
        return todoRepository.save(todo);
    }

    @Override
    public Todo update(Integer id, UpdateTodo update) throws NoSuchTodoException {
        Optional<Todo> todoOptional = todoRepository.findById(id);
        if(todoOptional.isPresent()) {
            Todo todo = todoOptional.get();
            if(update.getTitle() != null && !update.getTitle().isBlank()) {
                todo.setTitle(update.getTitle());
            }

            if(update.getDone() != null) {
                todo.setDone(update.getDone());
            }

            return todoRepository.save(todo);

        } else {
            throw new NoSuchTodoException();
        }

    }

    @Override
    public void delete(Integer id) throws NoSuchTodoException {
        if(todoRepository.existsById(id)) {
            todoRepository.deleteById(id);
        } else {
            throw new NoSuchTodoException();
        }
    }
}
