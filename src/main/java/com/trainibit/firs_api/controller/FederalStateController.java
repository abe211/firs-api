package com.trainibit.firs_api.controller;

import com.trainibit.firs_api.response.FederalStateResponse;
import com.trainibit.firs_api.service.FederalStateService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/federal_states")
public class FederalStateController {

    @Autowired
    private FederalStateService federalStateService;

    @GetMapping
    public ResponseEntity<List<FederalStateResponse>> getFederalStates() {
        return ResponseEntity.ok(federalStateService.getAllFederalStates());
    }


    @GetMapping("/{uuid}")
    public ResponseEntity<FederalStateResponse> getFederalState(@PathVariable UUID uuid) {
        return ResponseEntity.ok(federalStateService.getFederalStateByUuid(uuid));
    }

//    @PostMapping
//    public ResponseEntity<FederalStateResponse> createFederalState(@Valid @RequestBody FederalStateRequest federalStateRequest) {
//        return new ResponseEntity<>(federalStateService.createFederalState(federalStateRequest), CREATED);
//    }
}
