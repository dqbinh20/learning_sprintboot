package com.example.demo.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCreationRequest {
    @NotNull(message = "USERNAME_INVALID")
    String name;
    String password;
    String email;
    String phone;
    String address;
    LocalDate birthday;
}
