package com.rameez.restaurant.api.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RestaurantRepository {
    private final JdbcTemplate jdbcTemplate;

    public RestaurantRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<String> getRestaurantsBasedOnDietaryAllowance(List<String> allowanceIds) {
        String query = "SELECT DISTINCT restaurant_id from restaurant_dietary_endorsement WHERE dietary_restriction_type in (?)";
        return jdbcTemplate.queryForList(query, String.class, allowanceIds);
    }
}
