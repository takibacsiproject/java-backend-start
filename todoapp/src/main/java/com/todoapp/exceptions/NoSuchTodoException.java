package com.todoapp.exceptions;

import java.util.NoSuchElementException;

public class NoSuchTodoException extends NoSuchElementException {
    public static final String MESSAGE = "Nincs ilyen todo.";

    public NoSuchTodoException() {
        super(MESSAGE);
    }
}
