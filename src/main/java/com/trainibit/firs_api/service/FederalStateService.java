package com.trainibit.firs_api.service;

import com.trainibit.firs_api.response.FederalStateResponse;

import java.util.List;
import java.util.UUID;

public interface FederalStateService {
    FederalStateResponse getFederalStateByUuid(UUID uuid);
    List<FederalStateResponse> getAllFederalStates();
    FederalStateResponse CreateFederalState(FederalStateResponse federalState);
//    FederalStateReponse updateFederalState(UUID uuid, UserRequestPut userRequestPost);
}
