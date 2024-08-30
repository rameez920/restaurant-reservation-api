package com.rameez.restaurant.api.service;

import com.rameez.restaurant.api.entity.Reservation;
import com.rameez.restaurant.api.repository.ReservationRepository;
import com.rameez.restaurant.api.request.ReservationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<String> getAvailableReservations() {
        return null;
    }

    public boolean createReservation(ReservationRequest reservationRequest) {
        LocalDateTime startTime = reservationRequest.getStartTime();
        LocalDateTime endTime = reservationRequest.getEndTime();
        String restaurantId = reservationRequest.getRestaurantId();
        //get table Id from restaurantId
        List<Reservation> reservations = new ArrayList<>();
        for (String dinerId : reservationRequest.getDinerIds()) {
            Reservation reservation = new Reservation();
            reservations.add(reservation);
        }
        reservationRepository.createReservations(reservations);
        return false;
    }

}
