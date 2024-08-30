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

    public List<String> getRestaurantTables(List<String> restaurantIds, int capacity) {
        String query = "SELECT * from restaurant_table WHERE capacity >= ? and restaurant_id in (?)";
        return jdbcTemplate.queryForList(query, String.class, capacity, restaurantIds);
    }
}
