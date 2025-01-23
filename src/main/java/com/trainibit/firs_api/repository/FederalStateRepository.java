package com.trainibit.firs_api.repository;

import com.trainibit.firs_api.entity.FederalState;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FederalStateRepository extends JpaRepository<FederalState, Long> {
    FederalState findByUuid(UUID uuid);

}
