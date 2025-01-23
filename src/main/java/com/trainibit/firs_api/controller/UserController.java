package com.trainibit.firs_api.controller;
import com.trainibit.firs_api.request.UserRequest;
import com.trainibit.firs_api.response.UserResponse;
import com.trainibit.firs_api.service.UserService;
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


    @GetMapping
    public ResponseEntity<List<UserResponse>> getUsers(){

        return ResponseEntity.ok(userService.findAll());

    }
    @GetMapping("/{uuid}")
    public UserResponse getUserById(@PathVariable UUID uuid) {
        return userService.findByUuid(uuid);

    }
//    @PutMapping("/{uuid}")
//    public  UserResponse updateUser(@PathVariable UUID uuid, @RequestBody UserRequest userRequest) {
//        return userRequest.updateUser(uuid);
//    }
    @PostMapping
    public UserResponse saveUser(@RequestBody UserRequest userRequest) {
        return userService.save(userRequest);
    }

}
