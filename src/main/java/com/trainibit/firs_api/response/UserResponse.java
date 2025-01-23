package com.trainibit.firs_api.response;

import com.trainibit.firs_api.entity.FederalState;
import com.trainibit.firs_api.entity.RolesByUser;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class UserResponse {
    private String firsName;
    private String lastName;
    private UUID uuid;
    private Timestamp createdDate;
    private Timestamp updatedDate;
    private String age;
    private String email;
    private String planet;
    private LocalDate birthday;
    private FederalState federalState;
    private List<RolesByUser> roles;

}
