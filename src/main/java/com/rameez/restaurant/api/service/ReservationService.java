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

    public List<String> getExistingReservationsReservation(List<String> dinerIds, LocalDateTime startTime, LocalDateTime endTime) {
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
