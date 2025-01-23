package com.trainibit.firs_api.request;

import com.trainibit.firs_api.entity.FederalState;
import com.trainibit.firs_api.entity.RolesByUser;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class UserRequest {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String email;
    private UUID federalStateUuid;
    private List<RolesByUser> roles;

    public UserRequest(String firsName, String lastName, LocalDate birthDate, String email) {
        this.firstName = firsName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.email = email;
    }


}
