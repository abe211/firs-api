package com.trainibit.firs_api.mapper.impl;

import com.trainibit.firs_api.entity.FederalState;
import com.trainibit.firs_api.mapper.FederalStateMapper;
import com.trainibit.firs_api.request.FederalStateRequest;
import com.trainibit.firs_api.response.FederalStateResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FederalStateMapperImpl implements FederalStateMapper {

    @Override
    public FederalStateResponse entityToResponse(FederalState federalState) {
        return null;
    }

    @Override
    public List<FederalStateResponse> entityToResponseList(List<FederalState> federalStates) {
        return List.of();
    }

    @Override
    public FederalState requestToEntity(FederalStateRequest federalStateRequest) {
        return null;
    }
}
