package com.example.demo.exception;

public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(9999, "Uncategorized Exception"),
    KEY_INVALID(1001, "Key Invalid"),
    USER_EXISTED(1002,"User already existed"),
    USERNAME_INVALID(1003,"Name is not blank"),
    ;

    private final int code;
    private final String message;
    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
