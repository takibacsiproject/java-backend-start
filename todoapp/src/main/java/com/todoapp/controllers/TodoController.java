package com.todoapp.controllers;


import com.todoapp.models.dto.NewTodo;
import com.todoapp.models.dao.Todo;
import com.todoapp.models.dto.UpdateTodo;
import com.todoapp.services.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }
    @GetMapping
    public ResponseEntity<List<Todo>> getTodos(
            @RequestParam Optional<Boolean> isDone,
            @RequestParam Optional<String> q) {
        List<Todo> todos =todoService.getTodos(isDone, q);
        return ResponseEntity.status(HttpStatus.OK).body(todos);
   }

   @GetMapping("/{id}")
   public ResponseEntity<Todo> getById(@PathVariable Integer id) {
        Todo todo = todoService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(todo);
   }


   @PostMapping
    public ResponseEntity<Todo> save(@RequestBody NewTodo newTodo) {
        Todo savedTodo = todoService.save(newTodo);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTodo);
   }

   @PutMapping("/{id}")
    public ResponseEntity<Todo> update(@PathVariable Integer id, @RequestBody UpdateTodo update) {
            Todo updatedTodo = todoService.update(id, update);
            return ResponseEntity.status(HttpStatus.OK).body(updatedTodo);
   }

   @DeleteMapping("/{id}")
   public ResponseEntity<?> delete(@PathVariable Integer id) {
        todoService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
   }

}
