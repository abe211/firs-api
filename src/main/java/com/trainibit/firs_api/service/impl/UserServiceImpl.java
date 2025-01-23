package com.trainibit.firs_api.service.impl;

import com.trainibit.firs_api.entity.FederalState;
import com.trainibit.firs_api.entity.User;
import com.trainibit.firs_api.mapper.UserMapper;
import com.trainibit.firs_api.repository.FederalStateRepository;
import com.trainibit.firs_api.repository.UserRepository;
import com.trainibit.firs_api.request.UserRequest;
import com.trainibit.firs_api.response.UserResponse;
import com.trainibit.firs_api.response.extern.PlanetResponse;
import com.trainibit.firs_api.service.PlanetaService;
import com.trainibit.firs_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PlanetaService planetaService;
    @Autowired
    private FederalStateRepository federalStateRepository;


    @Override
    public List<UserResponse> findAll() {
        return userMapper.entityListToResponseList(userRepository.findAll()) ;
    }

    @Override
    public UserResponse findByUuid(UUID uuid) {
        return userMapper.entityToResponse(userRepository.findByUuid(uuid));
    }

    @Override
    public UserResponse save(UserRequest userRequest) {
        User user=userMapper.requestToEntity(userRequest);
        user.setFederalState(federalStateRepository.findByUuid(userRequest.getFederalStateUuid()));//pide de userrequest el get de federal state para setear y tranformar

        user.setUuid(UUID.randomUUID());
        user.setPlanet(obtainRandomPlanetName());
        User savedUser=userRepository.save(user);
        return userMapper.entityToResponse(savedUser);
    }

    private String obtainRandomPlanetName(){
        Random random = new Random();
        int randomNumber = random.nextInt(60) + 1;
        PlanetResponse randomPlanet = planetaService.getPlanetById(randomNumber);
        return randomPlanet.getResult().getProperties().getName();
    }

}
