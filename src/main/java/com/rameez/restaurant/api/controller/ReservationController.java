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

    public static final int RESERVATION_HOUR_LENGTH = 2;

    @Autowired
    private ReservationService reservationService;


    @GetMapping()
    public ResponseEntity<AvailableRestaurantsResponse> getAvailableRestaurants(@RequestParam LocalDateTime startTime, @RequestParam List<String> dinerIds) {
        if (overlappingReservationsExist(startTime, dinerIds)) {
            AvailableRestaurantsResponse response = new AvailableRestaurantsResponse();
            response.setMessage("diners have existing reservation during time");
            return ResponseEntity.badRequest().body(response);

        }
        List<RestaurantTable> availableTables = reservationService.getAvailableTablesForDiners(startTime, dinerIds);
        List<Restaurant> availableRestaurants = reservationService.getRestaurantsForTable(availableTables);
        AvailableRestaurantsResponse response = new AvailableRestaurantsResponse();
        response.setMessage("success");
        response.setRestaurants(availableRestaurants);
        return ResponseEntity.ok(response);
    }

    @PostMapping()
    public ResponseEntity<Object> createReservation(@RequestBody ReservationRequest reservationRequest) {
        try {
            if (overlappingReservationsExist(reservationRequest.getStartTime(), reservationRequest.getDinerIds())) {
                return ResponseEntity.badRequest().body("diners have existing reservation during time");
            }

            reservationService.createReservation(reservationRequest);
            return ResponseEntity.status(Response.SC_CREATED).build();
        } catch (Exception e) {
            System.err.println("Error creating reservations: " + e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping()
    public ResponseEntity<Object> deleteReservation(@RequestParam String reservationId) {
        try {
            reservationService.deleteReservation(reservationId);
            return ResponseEntity.ok("Reservation deleted");
        } catch (Exception e) {
            System.err.println("Error deleting reservation: " + e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    private boolean overlappingReservationsExist(LocalDateTime startTime, List<String> dinerIds) {
        List<String> dinersWithReservations = reservationService.getExistingReservationsForDiners(dinerIds, startTime, startTime.plusHours(RESERVATION_HOUR_LENGTH));
        return !dinersWithReservations.isEmpty();
    }

}
