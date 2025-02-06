package com.trainibit.firs_api.request;


import lombok.Data;

import java.util.UUID;

@Data
public class FederalStateRequest {
    public String name;
    public UUID uuid;
}
