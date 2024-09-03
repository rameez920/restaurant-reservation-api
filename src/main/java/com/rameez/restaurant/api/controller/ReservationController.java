package com.rameez.restaurant.api.controller;

import com.rameez.restaurant.api.entity.Restaurant;
import com.rameez.restaurant.api.entity.RestaurantTable;
import com.rameez.restaurant.api.request.ReservationRequest;
import com.rameez.restaurant.api.response.AvailableRestaurantsResponse;
import com.rameez.restaurant.api.service.ReservationService;
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
            return ResponseEntity.badRequest().build();

        }
        List<RestaurantTable> availableTables = reservationService.getAvailableTablesForDiners(startTime, dinerIds);
        List<Restaurant> availableRestaurants = reservationService.getRestaurants(availableTables);
        return null;
    }

    @PostMapping()
    public void createReservation(@RequestBody ReservationRequest reservationRequest) {
        //using restaurantId
        //user dinerIds to create reservations using  tableId
        //TODO: add response
        reservationService.createReservation(reservationRequest);
    }

    @DeleteMapping()
    public void deleteReservation(String reservationId) {

    }

}
