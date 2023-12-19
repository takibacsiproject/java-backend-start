package com.todoapp.controllers;

import com.todoapp.models.dao.TodoUser;
import com.todoapp.models.dto.NewUser;
import com.todoapp.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<TodoUser> getById(@PathVariable Integer id) {
       TodoUser user = userService.getById(id);
       return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @PostMapping
    public ResponseEntity<TodoUser> signUp(@RequestBody NewUser newUser) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(newUser));
    }


}
