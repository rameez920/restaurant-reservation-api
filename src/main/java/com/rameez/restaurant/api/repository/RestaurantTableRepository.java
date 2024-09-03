package com.rameez.restaurant.api.repository;

import com.rameez.restaurant.api.entity.RestaurantTable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class RestaurantTableRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    private final RowMapper<RestaurantTable> rowMapper = (rs, rowNum) -> {
        RestaurantTable restaurantTable = new RestaurantTable();
        restaurantTable.setTableId(rs.getString("id"));
        restaurantTable.setRestaurantId(rs.getString("restaurant_id"));
        restaurantTable.setCapacity(rs.getInt("capacity"));
        return restaurantTable;
    };

    public RestaurantTableRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Set<RestaurantTable> getRestaurantTables(List<String> restaurantIds, int capacity) {
        String query = "SELECT * from restaurant_table WHERE capacity >= :capacity and restaurant_id in (:restaurantIds)";

        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("capacity", capacity);
        parameters.addValue("restaurantIds", restaurantIds);

        return new HashSet<>(jdbcTemplate.query(query, parameters, rowMapper));
    }

    public RestaurantTable getAvailableTable(String restaurantId, LocalDateTime startTime, LocalDateTime endTime, int capacity) {
        String query = "SELECT * from restaurant_table WHERE capacity >= :capacity and restaurant_id = :restaurantId and id NOT IN (SELECT table_id FROM reservation WHERE (start_time >= :startTime or end_time <= :endTime)) ORDER BY capacity LIMIT 1";

        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("capacity", capacity);
        parameters.addValue("restaurantId", restaurantId);
        parameters.addValue("startTime", startTime);
        parameters.addValue("endTime", endTime);

        return jdbcTemplate.query(query, parameters, rowMapper).get(0);
    }
}
