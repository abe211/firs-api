package com.trainibit.firs_api.request;

import com.trainibit.firs_api.entity.RolesByUser;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class UserRequestPost {
    @NotBlank
    private String firstName;
    @NotEmpty
    private String lastName;
    @Past
    private LocalDate birthDate;
    @Email
    private String email;
    @NotNull
    private UUID federalStateUuid;
    @NotNull
    private List<RolesByUser> roles;
    @Negative
    private String age;

}
