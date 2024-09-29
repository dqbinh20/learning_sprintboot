package com.example.demo.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level= AccessLevel.PRIVATE, makeFinal=true)
public class AuthenticationRequest {
    String username;
    String password;
}
