package com.example.demo.exception;

import lombok.Getter;

@Getter
public class UserException extends RuntimeException {

    public UserException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
    private final ErrorCode errorCode;
}
