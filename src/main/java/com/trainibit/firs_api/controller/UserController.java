package com.trainibit.firs_api.controller;
import com.trainibit.firs_api.repository.UserRepository;
import com.trainibit.firs_api.entity.User;
import com.trainibit.firs_api.response.UserResponse;
import com.trainibit.firs_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping
    public ResponseEntity<List<UserResponse>> getUsers(){

        return ResponseEntity.ok(userService.findAll());

    }
    @GetMapping("/{id}")
    public User getUserById(@PathVariable UUID id) {
        return userService.getByUuId(UUID);
    }
}
