package com.rameez.restaurant.api.controller;

import com.rameez.restaurant.api.repository.DinerRepository;
import com.rameez.restaurant.api.repository.RestaurantRepository;
import com.rameez.restaurant.api.request.ReservationRequest;
import com.rameez.restaurant.api.response.AvailableReservations;
import com.rameez.restaurant.api.service.ReservationService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController()
@RequestMapping("/restaurants/reservations")
public class ReservationController {

    public static final int RESERVATION_HOUR_LENGTH = 2;
    @Autowired
    private ReservationService reservationService;

    @Autowired
    private DinerRepository dinerRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @GetMapping()
    public ResponseEntity<AvailableReservations> getAvailableRestaurants(@RequestParam LocalDateTime startTime, @RequestParam List<String> dinerIds) {
        //check for overlapping reservations
        List<String> dinersWithReservations = reservationService.getExistingReservationsReservation(dinerIds, startTime, startTime.plusHours(RESERVATION_HOUR_LENGTH));
        if (!dinersWithReservations.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        //1. get diner restrictions
        List<String> dietaryRestrictions = dinerRepository.getDinerRestrictions(dinerIds);
        //2. filter restaurants based on restrictions
        List<String> allowedRestaurants = restaurantRepository.getRestaurantsBasedOnDietaryAllowance(dietaryRestrictions);

        //3. check resutant_table to find tables with capacity
        //4. filter tables based on available reservation during time


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
