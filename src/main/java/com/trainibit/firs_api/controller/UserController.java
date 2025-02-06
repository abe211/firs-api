package com.trainibit.firs_api.controller;
import com.trainibit.firs_api.mapper.UserMapper;
import com.trainibit.firs_api.repository.UserRepository;
import com.trainibit.firs_api.request.UserRequestPost;
import com.trainibit.firs_api.response.UserResponse;
import com.trainibit.firs_api.service.UserService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;


    @GetMapping
    public ResponseEntity<List<UserResponse>> getUsers(){

        return ResponseEntity.ok(userService.findAll());

    }
    @GetMapping("/{uuid}")
    public UserResponse getUserById(@PathVariable UUID uuid) {
        return userService.findByUuid(uuid);

    }
//    @PutMapping("/{uuid}")
//    public  UserResponse updateUser(@Valid @PathVariable UUID uuid, @RequestBody UserRequest userRequest) {
//        UserRequest updateRequest = UserService.updateUser(UUID )
//        return userService.updateUser(UserRequest.userRequest);
//    }

    @PostMapping
    public UserResponse saveUser(@Valid @RequestBody UserRequestPost userRequest) {
        return userService.save(userRequest);
    }

}
