package com.example.demo.api;

import com.example.demo.dto.CustomError;
import com.example.demo.exception.UserExistsException;
import com.example.demo.exception.UserNotFoundException;
import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public CustomError handle(UserNotFoundException ex) {
        return new CustomError(ex.getMessage(), new Date(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserExistsException.class)
    public CustomError handle(UserExistsException ex) {
        return new CustomError(ex.getMessage(), new Date(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public CustomError handle(MethodArgumentTypeMismatchException ex){
        return new CustomError("path variable type mismatch", new Date(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public CustomError handle(MethodArgumentNotValidException ex) {
        return new CustomError("request body field mismatch", new Date(), HttpStatus.BAD_REQUEST);
    }
}
