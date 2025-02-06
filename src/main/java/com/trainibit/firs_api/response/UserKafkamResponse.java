package com.trainibit.firs_api.response;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
public class UserKafkamResponse {
    private UUID uuid;
    private String gmail;
    private String token;

}
