package com.todoapp.services;

import com.todoapp.exceptions.NoSuchUserException;
import com.todoapp.models.dao.TodoUser;
import com.todoapp.models.dto.NewUser;
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

    @Override
    public TodoUser save(NewUser newUser) {
        return userRepository.save(convertToUser(newUser));
    }

    public TodoUser convertToUser(NewUser newUser) {
        TodoUser user = new TodoUser();
        user.setUsername(newUser.getUsername());
        user.setPassword(newUser.getPassword());
        return user;
    }
}
