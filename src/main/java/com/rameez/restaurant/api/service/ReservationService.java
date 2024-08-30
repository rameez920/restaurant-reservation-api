package com.rameez.restaurant.api.service;

import com.rameez.restaurant.api.entity.Reservation;
import com.rameez.restaurant.api.repository.DinerRepository;
import com.rameez.restaurant.api.repository.ReservationRepository;
import com.rameez.restaurant.api.repository.RestaurantRepository;
import com.rameez.restaurant.api.repository.RestaurantTableRepository;
import com.rameez.restaurant.api.request.ReservationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Service
public class ReservationService {
    public static final int RESERVATION_HOUR_LENGTH = 2;

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private DinerRepository dinerRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private RestaurantTableRepository restaurantTableRepository;


    public List<String> getAvailableReservations(LocalDateTime startTime, List<String> dinerIds) {

        //1. get diner restrictions
        List<String> dietaryRestrictions = dinerRepository.getDinerRestrictions(dinerIds);
        //2. filter restaurants based on restrictions
        List<String> allowedRestaurants = restaurantRepository.getRestaurantsBasedOnDietaryAllowance(dietaryRestrictions);

        //3. check resutant_table to find tables with capacity
        List<String> tableIds = restaurantTableRepository.getRestaurantTables(allowedRestaurants, dinerIds.size());
        //4. filter tables based on available reservation during time
        List<String> reservedTables = reservationRepository.checkExistingReservation(tableIds, startTime, startTime.plusHours(RESERVATION_HOUR_LENGTH));
        return null;
    }

    public List<String> getExistingReservationsForDiners(List<String> dinerIds, LocalDateTime startTime, LocalDateTime endTime) {
        List<Reservation> reservations = reservationRepository.getReservationForDiners(startTime, endTime, dinerIds);
        return reservations.stream().map(Reservation::getDinerId).toList();
    }

    public boolean createReservation(ReservationRequest reservationRequest) {
        List<Reservation> reservations = new ArrayList<>();
        for (String dinerId : reservationRequest.getDinerIds()) {
            Reservation reservation = new Reservation
                    (
                            reservationRequest.getStartTime(),
                            reservationRequest.getEndTime(),
                            reservationRequest.getTableId(),
                            dinerId
                    );
            reservations.add(reservation);
        }
        reservationRepository.createReservations(reservations);
        return true;
    }

    public void deleteReservation(String reservationId) {
        reservationRepository.deleteReservation(reservationId);
    }

}
