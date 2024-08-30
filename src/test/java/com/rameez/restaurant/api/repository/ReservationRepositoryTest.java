package com.rameez.restaurant.api.repository;


import com.rameez.restaurant.api.entity.Reservation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@JdbcTest
@Import(ReservationRepository.class)
public class ReservationRepositoryTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ReservationRepository reservationRepository;

    private final LocalDateTime startTime = LocalDateTime.now();
    private final LocalDateTime endTime = LocalDateTime.now();

    @Test
    public void createReservationsTest() {
       String[] dinerIds = {"1", "2", "3", "4", "5", "6"};
       String tableId = "1";
       List<Reservation> reservationList = new ArrayList<>();
       for (String dinerId : dinerIds) {
           Reservation reservation = new Reservation(startTime, endTime, tableId, dinerId);
           reservationList.add(reservation);
       }
       reservationRepository.createReservations(reservationList);
       List<Reservation> res = jdbcTemplate.query("SELECT * FROM reservation", reservationRepository.getRowMapper());
       assertEquals(6, res.size());
    }

//    @Test
//    public void getReservationsTest() {
//        List<Integer> dinerIds = List.of(1, 2, 3, 4, 5, 6);
//        List<Reservation> reservations = reservationRepository.getReservationForDiners(startTime, endTime, dinerIds);
//        assertEquals(6, reservations.size());
//
//        List<Reservation> res = jdbcTemplate.query("SELECT * FROM reservation", reservationRepository.getRowMapper());
//        assertEquals(6, res.size());
//    }
}
