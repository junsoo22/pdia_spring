package com.example.demo.exception;

public class WrongLoginRequestException extends RuntimeException {
    public WrongLoginRequestException(String message) {
        super(message);
    }
}
