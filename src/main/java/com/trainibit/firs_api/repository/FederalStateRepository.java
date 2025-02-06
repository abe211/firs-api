package com.trainibit.firs_api.repository;

import com.trainibit.firs_api.entity.FederalState;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface FederalStateRepository extends JpaRepository<FederalState, Long> {
    List<FederalState> findAll();
    @NotNull
    FederalState findByUuid(UUID federalStateuuid);


}
