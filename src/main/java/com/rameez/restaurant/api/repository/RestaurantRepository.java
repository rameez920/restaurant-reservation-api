package com.rameez.restaurant.api.repository;

import com.rameez.restaurant.api.entity.Restaurant;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RestaurantRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    private final RowMapper<Restaurant> rowMapper = (rs, rowNum) -> {
        Restaurant restaurant = new Restaurant();
        restaurant.setId(rs.getString("id"));
        restaurant.setName(rs.getString("name"));
        return restaurant;
    };

    public RestaurantRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<String> getRestaurantsBasedOnDietaryAllowance(List<String> allowanceIds) {
        String query = "SELECT restaurant_id\n" +
                "FROM restaurant_dietary_endorsement\n" +
                "WHERE dietary_restriction_type IN (:allowanceIds)\n" +
                "GROUP BY restaurant_id\n" +
                "HAVING COUNT(DISTINCT dietary_restriction_type) = " + allowanceIds.size();

        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("allowanceIds", allowanceIds);
        return jdbcTemplate.queryForList(query, parameters, String.class);
    }

    public List<Restaurant> getRestaurants(List<String> restaurantIds) {
        String query = "SELECT * from restaurant WHERE id IN (:restaurantIds)";
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("restaurantIds", restaurantIds);
        return jdbcTemplate.query(query, parameters, rowMapper);
    }
}
