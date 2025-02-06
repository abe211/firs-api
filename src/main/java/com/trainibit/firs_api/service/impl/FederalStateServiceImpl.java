package com.trainibit.firs_api.service.impl;

import com.trainibit.firs_api.entity.FederalState;
import com.trainibit.firs_api.mapper.FederalStateMapper;
import com.trainibit.firs_api.repository.FederalStateRepository;
import com.trainibit.firs_api.response.FederalStateResponse;
import com.trainibit.firs_api.service.FederalStateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class FederalStateServiceImpl implements FederalStateService {
    @Autowired
    private FederalStateRepository federalStateRepository;
    @Autowired
    private FederalStateMapper federalStateMapper;



    @Override
    public FederalStateResponse getFederalStateByUuid(UUID uuid) {
        return null;
    }

    @Override
    public List<FederalStateResponse> getAllFederalStates() {
        return List.of();
    }

    @Override
    public FederalStateResponse CreateFederalState(FederalStateResponse federalState) {
        return null;
    }
}
