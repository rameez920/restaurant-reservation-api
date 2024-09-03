package com.rameez.restaurant.api.repository;

import com.rameez.restaurant.api.entity.Reservation;
import com.rameez.restaurant.api.entity.Restaurant;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RestaurantRepository {
    private final JdbcTemplate jdbcTemplate;

    private final RowMapper<Restaurant> rowMapper = (rs, rowNum) -> {
        Restaurant restaurant = new Restaurant();
        restaurant.setId(rs.getString("id"));
        restaurant.setName(rs.getString("name"));
        return restaurant;
    };

    public RestaurantRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<String> getRestaurantsBasedOnDietaryAllowance(List<String> allowanceIds) {
        String query = "SELECT DISTINCT restaurant_id from restaurant_dietary_endorsement WHERE dietary_restriction_type in (?)";
        return jdbcTemplate.queryForList(query, String.class, allowanceIds);
    }

    public List<Restaurant> getRestaurants(List<String> restaurantIds) {
        String query = "SELECT * from restaurant WHERE id IN (?)";
        return jdbcTemplate.query(query, rowMapper, restaurantIds);
    }
}
