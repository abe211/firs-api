package com.trainibit.firs_api.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "roles_by_users")
public class RolesByUser {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @JsonBackReference

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_date", insertable = false, updatable = false)
    private Timestamp createdDate;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "updated_date", insertable = false)
    private Timestamp updatedDate;

    @Column(name = "uuid", nullable = false)
    private UUID uuid;

//    @Column(name = "activated", nullable = false)
//    private Boolean activated;
}