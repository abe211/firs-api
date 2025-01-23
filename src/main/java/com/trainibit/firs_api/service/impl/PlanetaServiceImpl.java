package com.trainibit.firs_api.service.impl;

import com.trainibit.firs_api.response.extern.PlanetResponse;
import com.trainibit.firs_api.service.PlanetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PlanetaServiceImpl implements PlanetaService {

    @Autowired
    private RestTemplate restTemplate;



    @Override
    public PlanetResponse getPlanetById(int id) {
        String url = "https://www.swapi.tech/api/planets/" + id;
        return restTemplate.getForObject(url, PlanetResponse.class);
    }


}
