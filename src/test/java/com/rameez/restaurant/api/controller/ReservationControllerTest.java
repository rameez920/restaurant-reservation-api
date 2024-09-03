package com.rameez.restaurant.api.controller;

import com.rameez.restaurant.api.entity.Reservation;
import com.rameez.restaurant.api.repository.ReservationRepository;
import com.rameez.restaurant.api.request.ReservationRequest;
import com.rameez.restaurant.api.response.AvailableRestaurantsResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
public class ReservationControllerTest {

    @Autowired
    private ReservationController reservationController;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ReservationRepository reservationRepository;


    @Test
    public void getRestaurantsBasedOnRestrictionsTest() {
        LocalDateTime startTime = LocalDateTime.now();
        List<String> dinerIds = List.of("1", "2");
        ResponseEntity<AvailableRestaurantsResponse> response = reservationController.getAvailableRestaurants(startTime, dinerIds);
        assertTrue(response.getStatusCode().is2xxSuccessful());
        AvailableRestaurantsResponse availableRestaurantsResponse = response.getBody();
        assertEquals(1, availableRestaurantsResponse.getRestaurants().size());
        assertEquals("2", availableRestaurantsResponse.getRestaurants().get(0).getId());
    }

    @Test
    public void createReservationTest() {
        LocalDateTime startTime = LocalDateTime.now();
        LocalDateTime endTime = LocalDateTime.now().plusHours(2);

        ReservationRequest request = new ReservationRequest();
        request.setDinerIds(List.of("1", "2"));
        request.setRestaurantId("2");
        request.setStartTime(LocalDateTime.now());
        ResponseEntity<Object> response = reservationController.createReservation(request);
        assertTrue(response.getStatusCode().is2xxSuccessful());

        List<Reservation> createdReservation = jdbcTemplate.query("SELECT * FROM reservation WHERE diner_id = 1 or diner_id = 2", reservationRepository.getRowMapper());
        assertEquals(2, createdReservation.size());
        assertEquals(startTime.truncatedTo(ChronoUnit.SECONDS), createdReservation.get(0).getStartTime().truncatedTo(ChronoUnit.SECONDS));
        assertEquals(endTime.truncatedTo(ChronoUnit.SECONDS), createdReservation.get(0).getEndTime().truncatedTo(ChronoUnit.SECONDS));
    }

    @Test
    public void usersAreNotAbleToDoubleBook() {
        LocalDateTime startTime = LocalDateTime.now().plusHours(1);
        List<String> dinerIds = List.of("1", "2");

        ResponseEntity<AvailableRestaurantsResponse> availableRestaurants = reservationController.getAvailableRestaurants(startTime, dinerIds);
        assertTrue(availableRestaurants.getStatusCode().is4xxClientError());

        ReservationRequest request = new ReservationRequest();

        request.setDinerIds(dinerIds);
        request.setRestaurantId("2");
        request.setStartTime(LocalDateTime.now());
        ResponseEntity<Object> reservationResponse = reservationController.createReservation(request);
        assertTrue(reservationResponse.getStatusCode().is4xxClientError());
    }

}
