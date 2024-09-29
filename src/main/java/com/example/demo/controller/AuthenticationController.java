package com.example.demo.controller;

import com.example.demo.dto.request.AuthenticationRequest;
import com.example.demo.dto.response.ApiResponse;
import com.example.demo.dto.response.AuthenticationResponse;
import com.example.demo.service.AuthenticationService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationController {
    AuthenticationService authenticationService;

    @PostMapping("/login")
    ApiResponse<AuthenticationResponse> login(@RequestBody AuthenticationRequest request){
        boolean isAuthenticated = authenticationService.authenticate(request);
        ApiResponse<AuthenticationResponse> apiResponse = new ApiResponse<>();
        apiResponse.setData(new AuthenticationResponse(isAuthenticated));
        return apiResponse;
//        try{
//            return ApiResponse.<AuthenticationResponse>builder()
//                    .data(AuthenticationResponse.builder()
//                            .authenticated(isAuthenticated)
//                            .build())
//                    .build();
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }
//        return null;
    }
}
