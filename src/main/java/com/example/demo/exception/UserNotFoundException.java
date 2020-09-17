package com.example.demo.exception;

// GTB: 可以让两个自定义异常先集成自同样自定义异常基类
public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException() {
        super("User Not Found");
    }
}
