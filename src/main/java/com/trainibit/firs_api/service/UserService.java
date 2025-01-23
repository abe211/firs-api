package com.trainibit.firs_api.service;

import com.trainibit.firs_api.request.UserRequest;
import com.trainibit.firs_api.response.UserResponse;
import com.trainibit.firs_api.response.extern.PlanetResponse;

import java.util.List;
import java.util.UUID;

public interface UserService {
    List<UserResponse>  findAll();
    UserResponse findByUuid(UUID uuid);
    UserResponse save(UserRequest userRequest);
}
