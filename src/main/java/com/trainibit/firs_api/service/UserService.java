package com.trainibit.firs_api.service;

import com.trainibit.firs_api.request.UserRequestPost;
import com.trainibit.firs_api.request.UserRequestPut;
import com.trainibit.firs_api.response.UserResponse;

import java.util.List;
import java.util.UUID;


public interface UserService {
    List<UserResponse>  findAll();
    UserResponse findByUuid(UUID uuid);
    UserResponse save(UserRequestPost userRequest);
    UserResponse update(UUID uuid,UserRequestPut userRequestPut);
}
