package com.trainibit.firs_api.mapper.impl;

import com.trainibit.firs_api.entity.User;
import com.trainibit.firs_api.mapper.UserMapper;
import com.trainibit.firs_api.response.UserResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserMapperImpl implements UserMapper {

    @Override
    public UserResponse entityToResponse(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setFirsName(user.getName());
        userResponse.setLastName(user.getLastName());
        userResponse.setEmail(user.getEmail());
        userResponse.setCreatedDate(user.getCreatedDate());
        userResponse.setUpdatedDate(user.getUpdatedDate());
        userResponse.setUuid(user.getUuid());
        return userResponse;
    }

    @Override
    public List<UserResponse> entityListToResponseList(List<User> userList) {
        List<UserResponse> userResponseList = new ArrayList<>();
        userList.forEach(user -> userResponseList.add(entityToResponse(user)));
        return userResponseList;
    }





}
