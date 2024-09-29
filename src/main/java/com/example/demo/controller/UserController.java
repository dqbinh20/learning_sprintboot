package com.example.demo.controller;

import com.example.demo.dto.request.ApiResponse;
import com.example.demo.dto.request.UserCreationRequest;
import com.example.demo.dto.request.UserUpdateRequest;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    ApiResponse<User> createUser(@Validated @RequestBody UserCreationRequest request) {
        ApiResponse<User> apiResponse = new ApiResponse<>();

        apiResponse.setData(userService.createUser(request));
        apiResponse.setCode(200);
        apiResponse.setMessage("Success");
        return apiResponse;
    }

    @GetMapping
    List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    User getUserById(@PathVariable("userId") String user_id) {
        return userService.getUserById(user_id);
    }

    @PutMapping("/{userId}")
    User updateUser(@PathVariable String userId, @RequestBody UserUpdateRequest request) { return userService.updateUser(userId, request); }
}

