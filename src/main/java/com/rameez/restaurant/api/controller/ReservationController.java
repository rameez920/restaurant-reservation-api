package com.rameez.restaurant.api.controller;

import com.rameez.restaurant.api.entity.Restaurant;
import com.rameez.restaurant.api.entity.RestaurantTable;
import com.rameez.restaurant.api.request.ReservationRequest;
import com.rameez.restaurant.api.response.AvailableRestaurantsResponse;
import com.rameez.restaurant.api.service.ReservationService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController()
@RequestMapping("/restaurants/reservations")
public class ReservationController {


    @Autowired
    private ReservationService reservationService;


    @GetMapping()
    public ResponseEntity<AvailableRestaurantsResponse> getAvailableRestaurants(@RequestParam LocalDateTime startTime, @RequestParam List<String> dinerIds) {
        //check for overlapping reservations
       // LocalDateTime
        List<String> dinersWithReservations = reservationService.getExistingReservationsForDiners(dinerIds, startTime, startTime.plusHours(2));
        if (!dinersWithReservations.isEmpty()) {
            AvailableRestaurantsResponse response = new AvailableRestaurantsResponse();
            response.setMessage("double booked reservations");
            return ResponseEntity.badRequest().body(response);

        }
        List<RestaurantTable> availableTables = reservationService.getAvailableTablesForDiners(startTime, dinerIds);
        List<Restaurant> availableRestaurants = reservationService.getRestaurants(availableTables);
        AvailableRestaurantsResponse response = new AvailableRestaurantsResponse();
        response.setMessage("success");
        response.setRestaurants(availableRestaurants);
        return ResponseEntity.ok(response);
    }

    @PostMapping()
    public ResponseEntity<Object> createReservation(@RequestBody ReservationRequest reservationRequest) {
        try {
            reservationService.createReservation(reservationRequest);
            return ResponseEntity.status(Response.SC_CREATED).build();
        } catch (Exception e) {
            System.err.println("Error creating reservations: " + e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping()
    public void deleteReservation(String reservationId) {
        reservationService.deleteReservation(reservationId);
    }

}
