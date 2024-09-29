package com.example.demo.service;

import com.example.demo.dto.request.ApiResponse;
import com.example.demo.dto.request.UserCreationRequest;
import com.example.demo.dto.request.UserUpdateRequest;
import com.example.demo.entity.User;
import com.example.demo.exception.ErrorCode;
import com.example.demo.exception.UserException;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(UserCreationRequest request){
        User user = new User();

        if (userRepository.existsByName(request.getName())){
            throw new UserException(ErrorCode.USER_EXISTED);
        }
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setPhone(request.getPhone());
        user.setAddress(request.getAddress());
        user.setBirthday(request.getBirthday());

        return userRepository.save(user);
    }

    public User updateUser(String userId, UserUpdateRequest request){
        User user = getUserById(userId);
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setPhone(request.getPhone());
        user.setAddress(request.getAddress());
        user.setBirthday(request.getBirthday());

        return userRepository.save(user);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(String id){
        return userRepository.findById(id).orElseThrow( () -> new RuntimeException("User Not Found"));
    }


}
