package com.trainibit.firs_api.service.impl;

import com.trainibit.firs_api.entity.User;
import com.trainibit.firs_api.mapper.UserMapper;
import com.trainibit.firs_api.repository.FederalStateRepository;
import com.trainibit.firs_api.repository.UserRepository;
import com.trainibit.firs_api.request.UserRequestPost;
import com.trainibit.firs_api.request.UserRequestPut;
import com.trainibit.firs_api.response.UserKafkamResponse;
import com.trainibit.firs_api.response.UserResponse;
import com.trainibit.firs_api.response.extern.PlanetResponse;
import com.trainibit.firs_api.service.KafkamService;
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

    @Autowired
    private KafkamService kafkamService;



    @Override
    public List<UserResponse> findAll() {
        return userMapper.entityListToResponseList(userRepository.findAll()) ;
    }

    @Override
    public UserResponse findByUuid(UUID uuid) {
        return userMapper.entityToResponse(userRepository.findByUuid(uuid));
    }



    @Override
    public UserResponse save(UserRequestPost userRequest) {
        User user=userMapper.requestToEntity(userRequest);
        user.setFederalState(federalStateRepository.findByUuid(userRequest.getFederalStateUuid()));//pide de userrequest el get de federal state para setear y tranformar
        user.setUuid(UUID.randomUUID());
        user.setPlanet(obtainRandomPlanetName());
        User savedUser=userRepository.save(user);
        UserKafkamResponse userKafkamResponse=new UserKafkamResponse();
        userKafkamResponse.setUuid(savedUser.getUuid());
        userKafkamResponse.setGmail(user.getEmail());
        userKafkamResponse.setToken(savedUser.getToken());
        kafkamService.sendMessage(userKafkamResponse);
        return userMapper.entityToResponse(savedUser);
    }

    @Override
    public UserResponse update(UUID uuid, UserRequestPut userRequestPut) {
        return null;
    }


    private String obtainRandomPlanetName(){
        Random random = new Random();
        int randomNumber = random.nextInt(60) + 1;
        PlanetResponse randomPlanet = planetaService.getPlanetById(randomNumber);
        return randomPlanet.getResult().getProperties().getName();
    }


}
