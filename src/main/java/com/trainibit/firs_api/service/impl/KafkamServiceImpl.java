package com.trainibit.firs_api.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trainibit.firs_api.response.UserKafkamResponse;
import com.trainibit.firs_api.service.KafkamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkamServiceImpl implements KafkamService {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private final String topicName = "user_registered";

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void sendMessage(UserKafkamResponse userKafkamResponse) {
        try{
            CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send(topicName, userKafkamResponse.getUuid().toString(), objectMapper.writeValueAsString(userKafkamResponse));
            future.whenComplete((result, ex) -> {
                if (ex == null) {
                    System.out.println("Sent message=[" + userKafkamResponse.getGmail() +
                            "] with offset=[" + result.getRecordMetadata().offset() + "]");
                } else {
                    System.out.println("Unable to send message=[" +
                            userKafkamResponse.getGmail() + "] due to : " + ex.getMessage());
                }
            });
        }catch (Exception e){
            throw new RuntimeException("Error converting UserResponseKafkca to JSON", e);
        }
    }

    
}
