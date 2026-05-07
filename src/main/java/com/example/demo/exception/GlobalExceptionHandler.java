package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler{

    @ExceptionHandler(DuplicatedUserException.class)
    public ResponseEntity<String> handleDuplicatedUserException(){
        return ResponseEntity.status(HttpStatus.CONFLICT).body("중복된 사용자입니다.");
    }

}
