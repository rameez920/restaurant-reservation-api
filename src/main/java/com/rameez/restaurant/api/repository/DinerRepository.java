package com.rameez.restaurant.api.repository;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DinerRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public DinerRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<String> getDinerRestrictions(List<String> dinerIds) {
        String query = "SELECT DISTINCT dietary_restriction_type from diner_dietary_restriction WHERE diner_id in (:dinerIds)";

        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("dinerIds", dinerIds);

        return jdbcTemplate.queryForList(query, parameters, String.class);
    }

}
