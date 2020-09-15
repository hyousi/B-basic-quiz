package com.example.demo.dto;

import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
public class CustomError {

    String message;

    Date timestamp;

    Integer status;

    String error;

    public CustomError(String message) {
        this.message = message;
    }

    public CustomError(String message, Date timestamp, HttpStatus httpStatus) {
        this.message = message;
        this.timestamp = timestamp;
        this.status = httpStatus.value();
        this.error = httpStatus.getReasonPhrase();
    }
}
