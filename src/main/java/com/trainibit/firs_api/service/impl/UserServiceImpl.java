package com.trainibit.firs_api.service.impl;

import com.trainibit.firs_api.entity.User;
import com.trainibit.firs_api.mapper.UserMapper;
import com.trainibit.firs_api.repository.UserRepository;
import com.trainibit.firs_api.response.UserResponse;
import com.trainibit.firs_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserResponse> findAll() {
        return userMapper.entityListToResponseList(userRepository.findAll()) ;
    }

    @Override
    public UserResponse findByUuid(UUID uuid) {
        return userMapper.entityToResponse(userRepository.findByUuid(uuid));
    }
}
