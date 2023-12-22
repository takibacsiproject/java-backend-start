package com.todoapp.services;

import com.todoapp.exceptions.ForbiddenActionException;
import com.todoapp.exceptions.NoSuchTodoException;
import com.todoapp.exceptions.NoSuchUserException;
import com.todoapp.models.dao.TodoUser;
import com.todoapp.models.dto.NewTodo;
import com.todoapp.models.dao.Todo;
import com.todoapp.models.dto.UpdateTodo;
import com.todoapp.repositories.TodoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {

    private UserService userService;
    private TodoRepository todoRepository;


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
    public Todo save(Integer userId, NewTodo newTodo) throws NoSuchUserException {
        Todo todo = convertToTodo(userId, newTodo);
        return todoRepository.save(todo);
    }


    @Override
    public Todo update(Integer userId, Integer todoId, UpdateTodo update)
            throws NoSuchUserException, NoSuchTodoException, ForbiddenActionException {
        TodoUser user = userService.getById(userId);
        Optional<Todo> todoOptional = todoRepository.findById(todoId);
        if(todoOptional.isPresent()) {
            if (!todoOptional.get().getOwner().getId().equals(user.getId())) {
                throw new ForbiddenActionException();
            }
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
    public void delete(Integer userId, Integer todoId)
            throws NoSuchTodoException, NoSuchUserException, ForbiddenActionException {
        TodoUser user = userService.getById(userId);

        Optional<Todo> todo = todoRepository.findById(todoId);
        if(todo.isPresent()) {
            if(todo.get().getOwner().getId().equals(user.getId())) {
                todoRepository.deleteById(todoId);
            } else {
                throw new ForbiddenActionException();
            }

        } else {
            throw new NoSuchTodoException();
        }
    }

    public Todo convertToTodo(Integer userId, NewTodo newTodo) throws NoSuchUserException {
        TodoUser user = userService.getById(userId);
        Todo todo =  new Todo(newTodo.getTitle(), false);
        todo.setOwner(user);
        return todo;
    }
}
