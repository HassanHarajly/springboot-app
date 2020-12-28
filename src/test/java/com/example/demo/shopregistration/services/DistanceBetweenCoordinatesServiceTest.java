package com.example.demo.shopregistration.services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DistanceBetweenCoordinatesServiceTest {


    DistanceBetweenCoordinatesService distanceBetweenCoordinatesService;

    @Test
    void distance() {
        assertEquals(distanceBetweenCoordinatesService.distance(32.9697, -96.80322,
                29.46786, -98.53506, "M"),262.6777938054349);
        assertEquals(distanceBetweenCoordinatesService.distance(32.9697, -96.80322,
                29.46786, -98.53506, "K"), 422.73893139401383);
    }
}
