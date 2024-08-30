package com.rameez.restaurant.api.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DinerRepository {
    private final JdbcTemplate jdbcTemplate;

    public DinerRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<String> getDinerRestrictions(List<String> dinerIds) {
        String query = "SELECT DISTINCT dietary_restriction_type from diner_dietary_restriction WHERE diner_id in (?)";
        return jdbcTemplate.queryForList(query, String.class, dinerIds);
    }
}
