package com.trainibit.firs_api.mapper;

import com.trainibit.firs_api.entity.User;
import com.trainibit.firs_api.repository.UserRepository;
import com.trainibit.firs_api.response.UserResponse;

import java.util.List;


public interface UserMapper {
    UserResponse entityToResponse(User user);
    List<UserResponse> entityListToResponseList (List<User> userList);
}
