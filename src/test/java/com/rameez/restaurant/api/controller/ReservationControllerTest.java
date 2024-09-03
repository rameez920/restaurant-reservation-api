package com.rameez.restaurant.api.controller;

import com.rameez.restaurant.api.response.AvailableRestaurantsResponse;
import org.apache.catalina.connector.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
public class ReservationControllerTest {

    @Autowired
    private ReservationController reservationController;


    @Test
    public void getRestaurantsBasedOnRestrictionsTest() {
        LocalDateTime startTime = LocalDateTime.now();
        List<String> dinerIds = List.of("1", "2");
        ResponseEntity<AvailableRestaurantsResponse> response = reservationController.getAvailableRestaurants(startTime, dinerIds);
        assertTrue(response.getStatusCode().is2xxSuccessful());
        AvailableRestaurantsResponse availableRestaurantsResponse = response.getBody();
        assertEquals(1, availableRestaurantsResponse.getRestaurants().size());
        assertEquals("2", availableRestaurantsResponse.getRestaurants().get(0).getId());
    }

}
