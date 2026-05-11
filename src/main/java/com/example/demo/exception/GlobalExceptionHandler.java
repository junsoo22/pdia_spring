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

    @ExceptionHandler(WrongLoginRequestException.class)
    public ResponseEntity<String> handleWrongLoginRequestException(){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("아이디 또는 비밀번호 오류입니다. 정확히 입력해주세요.");
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleUserNotFound(){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("아이디 또는 비밀번호 오류입니다. 정확히 입력해주세요.");
    }

}
