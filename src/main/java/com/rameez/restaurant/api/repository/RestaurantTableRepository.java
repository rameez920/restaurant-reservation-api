package com.rameez.restaurant.api.repository;

import com.rameez.restaurant.api.entity.RestaurantTable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class RestaurantTableRepository {

    private final JdbcTemplate jdbcTemplate;

    private final RowMapper<RestaurantTable> rowMapper = (rs, rowNum) -> {
        RestaurantTable restaurantTable = new RestaurantTable();
        restaurantTable.setTableId(rs.getString("table_id"));
        restaurantTable.setRestaurantId(rs.getString("restaurant_id"));
        restaurantTable.setCapacity(rs.getInt("capacity"));
        return restaurantTable;
    };

    public RestaurantTableRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Set<RestaurantTable> getRestaurantTables(List<String> restaurantIds, int capacity) {
        String query = "SELECT * from restaurant_table WHERE capacity >= ? and restaurant_id in (?)";
        return new HashSet<>(jdbcTemplate.query(query, rowMapper, capacity, restaurantIds));
    }

    public RestaurantTable getAvailableTable(String restrauntId, String startTime, String endTime, int capacity) {
        String query = "SELECT * from restaurant_table WHERE capacity >= ? and restaurant_id = ? and table_id NOT IN (SELECT table_id FROM reservation WHERE (start_time >= ? or end_time <= ?)) ORDER BY capacity LIMIT 1";
        return jdbcTemplate.query(query, rowMapper, capacity, restrauntId, startTime, endTime).get(0);
    }
}
