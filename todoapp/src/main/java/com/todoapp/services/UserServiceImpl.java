package com.todoapp.services;

import com.todoapp.exceptions.NoSuchUserException;
import com.todoapp.models.dao.TodoUser;
import com.todoapp.repositories.TodoUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private TodoUserRepository userRepository;
    @Override
    public TodoUser getById(Integer id) throws NoSuchUserException {
        return userRepository.findById(id).orElseThrow(() -> new NoSuchUserException(id));
    }
}
