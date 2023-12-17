package com.todoapp.repositories;

import com.todoapp.models.dao.Todo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TodoRepository extends CrudRepository<Todo, Integer> {
    List<Todo> findAll();

}
