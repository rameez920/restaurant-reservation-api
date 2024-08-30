package com.rameez.restaurant.api.controller;

import com.rameez.restaurant.api.request.ReservationRequest;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController()
@RequestMapping("/restaurants/reservations")
public class ReservationController {


    @GetMapping()
    public List<String> getAvailableRestaurants(@RequestParam LocalDate startTime, @RequestParam List<String> dinerIds) {
        return null;
        //check for overlapping reservations
        //check resutant_table to find tables with capacity check tables with overlapping reservations -- filter restaurantIds
        // filter restaurantIds by dietary restrictions
        //get user dietary restrictions, filter restaurants by restrictions
        //return restaurant IDs
    }

    @PostMapping()
    public void createReservation(@RequestBody ReservationRequest reservationRequest) {
        //using restaurantId
        //user dinerIds to create reservations using  tableId
    }

}
