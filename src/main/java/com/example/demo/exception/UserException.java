package com.example.demo.exception;

public class UserException extends RuntimeException {

    public UserException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
    private final ErrorCode errorCode;

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
