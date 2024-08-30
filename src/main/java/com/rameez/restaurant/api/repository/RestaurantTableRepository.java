package com.rameez.restaurant.api.repository;

import com.rameez.restaurant.api.entity.RestaurantTable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RestaurantTableRepository {

    private final JdbcTemplate jdbcTemplate;

    public RestaurantTableRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<RestaurantTable> getRestaurantTables(List<String> restaurantIds, int capacity) {
        return null;
    }
}
