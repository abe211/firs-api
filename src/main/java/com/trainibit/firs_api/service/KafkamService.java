package com.trainibit.firs_api.service;


import com.trainibit.firs_api.response.UserKafkamResponse;

public interface KafkamService {
    void sendMessage(UserKafkamResponse userKafkamResponse);
}
