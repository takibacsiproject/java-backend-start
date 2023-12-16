package com.todoapp.controllers;

import com.todoapp.models.Todo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {
    @GetMapping("/todo")
    public ResponseEntity<Todo> getTodo() {
        Todo todo = new Todo("kutyat setaltatni", false);
        return ResponseEntity.status(HttpStatus.OK).body(todo);
       // return ResponseEntity.ok(todo);
   }
}
