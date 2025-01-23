package com.trainibit.firs_api.response.extern;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlanetResultResponse {
    PlanetPropiertiesResponse properties;
    private String description;
    private String _id;
    private String uid;
    private Integer __v;
}
