package com.todoapp.controllers;

import com.todoapp.models.dto.Login;
import com.todoapp.models.dto.Token;
import com.todoapp.services.LoginService;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class LoginController {

    private LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<Token> login(@RequestBody Login login) {
        return ResponseEntity.status(HttpStatus.OK).body(loginService.login(login));
    }

}
