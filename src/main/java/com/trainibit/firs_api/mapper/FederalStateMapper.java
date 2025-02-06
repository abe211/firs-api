package com.trainibit.firs_api.mapper;

import com.trainibit.firs_api.entity.FederalState;
import com.trainibit.firs_api.request.FederalStateRequest;
import com.trainibit.firs_api.response.FederalStateResponse;

import java.util.List;

public interface FederalStateMapper {
    FederalStateResponse entityToResponse(FederalState federalState);
    List<FederalStateResponse> entityToResponseList(List<FederalState> federalStates);
    FederalState requestToEntity(FederalStateRequest federalStateRequest);
}
