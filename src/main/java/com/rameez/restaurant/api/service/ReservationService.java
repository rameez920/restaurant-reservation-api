package com.rameez.restaurant.api.service;

import com.rameez.restaurant.api.entity.Reservation;
import com.rameez.restaurant.api.entity.Restaurant;
import com.rameez.restaurant.api.entity.RestaurantTable;
import com.rameez.restaurant.api.repository.DinerRepository;
import com.rameez.restaurant.api.repository.ReservationRepository;
import com.rameez.restaurant.api.repository.RestaurantRepository;
import com.rameez.restaurant.api.repository.RestaurantTableRepository;
import com.rameez.restaurant.api.request.ReservationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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


    public List<RestaurantTable> getAvailableTablesForDiners(LocalDateTime startTime, List<String> dinerIds) {
        //1. get diner restrictions
        List<String> dietaryRestrictions = dinerRepository.getDinerRestrictions(dinerIds);
        //2. filter restaurants based on restrictions
        List<String> allowedRestaurants = restaurantRepository.getRestaurantsBasedOnDietaryAllowance(dietaryRestrictions);

        //3. tables with capacity
        Set<RestaurantTable> restaurantTables = restaurantTableRepository.getRestaurantTables(allowedRestaurants, dinerIds.size());
        List<String> tableIds = restaurantTables.stream().map(RestaurantTable::getTableId).collect(Collectors.toList());
        //4. filter tables based on available reservation during time
        List<String> reservedTables = reservationRepository.checkExistingReservation(tableIds, startTime, startTime.plusHours(RESERVATION_HOUR_LENGTH));
        for (String reservedTableId : reservedTables) {
            restaurantTables.remove(reservedTableId);
        }
        return new ArrayList<>(restaurantTables);
    }

    public List<Restaurant> getRestaurants(List<RestaurantTable> availableTables) {
        Set<String> restaurantIds = new HashSet<>();
        for (RestaurantTable table : availableTables) {
            restaurantIds.add(table.getRestaurantId());
        }
        return restaurantRepository.getRestaurants(new ArrayList<>(restaurantIds));
    }

    public List<String> getExistingReservationsForDiners(List<String> dinerIds, LocalDateTime startTime, LocalDateTime endTime) {
        List<Reservation> reservations = reservationRepository.getReservationForDiners(startTime, endTime, dinerIds);
        return reservations.stream().map(Reservation::getDinerId).toList();
    }

    public boolean createReservation(ReservationRequest reservationRequest) {
        String restaurantId = reservationRequest.getRestaurantId();
        LocalDateTime startTime = reservationRequest.getStartTime();
        LocalDateTime endTime = reservationRequest.getStartTime().plusHours(RESERVATION_HOUR_LENGTH);
        int capacity = reservationRequest.getDinerIds().size();

        String availableTableId = restaurantTableRepository.getAvailableTable(restaurantId, startTime, endTime, capacity).getTableId();
        List<Reservation> reservations = new ArrayList<>();
        for (String dinerId : reservationRequest.getDinerIds()) {
            reservations.add(new Reservation(startTime, endTime, availableTableId, dinerId));
        }
        reservationRepository.createReservations(reservations);
        return true;
    }

    public void deleteReservation(String reservationId) {
        reservationRepository.deleteReservation(reservationId);
    }

}
