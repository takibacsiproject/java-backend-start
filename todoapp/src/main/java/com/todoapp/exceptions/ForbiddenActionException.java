package com.todoapp.exceptions;

public class ForbiddenActionException extends RuntimeException {

    public static final String MESSAGE = "HÉ-HÉ, nono, ilyet nem szabad!";

    public ForbiddenActionException() {
        super(MESSAGE);
    }
}
