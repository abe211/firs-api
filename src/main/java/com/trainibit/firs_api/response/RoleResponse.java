package com.trainibit.firs_api.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

@Data
public class RoleResponse implements Serializable {
    private String name;
    private Timestamp createdDate;
    private Timestamp updatedDate;
    private UUID uuid;
}
