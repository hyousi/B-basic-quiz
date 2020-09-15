package com.example.demo.exception;

public class UserExistsException extends RuntimeException {

    public UserExistsException() {
        super("User exists");
    }
}
