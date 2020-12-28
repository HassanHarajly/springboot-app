package com.example.demo.shopregistration.services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GeoCacheApiServiceTest {

    GeoCacheApiService geoCacheApiService = new GeoCacheApiService();
    @Test
    void getApiResponse() {
        assertEquals(geoCacheApiService.getApiResponse("1600 Pennsylvania Ave%20NW, Washington DC").getData().get(0).getLatitude()
               ,38.897675);
    }
}
