package com.example.demo.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.logging.Level;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(9999, "Uncategorized Exception"),
    KEY_INVALID(1001, "Key Invalid"),
    USER_EXISTED(1002,"User already existed"),
    USERNAME_INVALID(1003,"Name is not blank"),
    USER_NOTFOUND(1004,"User not found"),
    ;

    int code;
    String message;
    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
