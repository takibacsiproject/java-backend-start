package com.todoapp.services;

import com.todoapp.exceptions.NoSuchUserException;
import com.todoapp.models.dao.TodoUser;

public interface UserService {
    TodoUser getById(Integer id) throws NoSuchUserException;
}
