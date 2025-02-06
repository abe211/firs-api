package com.trainibit.firs_api.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
@Getter
@Setter
@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "name", nullable = false)
    private String name;


    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name= "birthdate")
    private LocalDate birthdate;

    @Column(name= "created_date", insertable = false, updatable = false)
    private Timestamp createdDate;

    @Column(name= "updated_date", insertable = false)
    private Timestamp updatedDate;

    @Column(name= "uuid")
    private UUID uuid;

    @Column(name = "planet")
    private String planet;
    @Column(name = "token")
    private String token;




    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "Federal_state_id", nullable = false)
    private FederalState federalState;

    @JsonBackReference

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<RolesByUser> roles = new ArrayList<>();
}
