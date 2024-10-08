package com.rameez.restaurant.api.repository;

import com.rameez.restaurant.api.entity.Reservation;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class ReservationRepository {
    private final JdbcTemplate jdbcTemplate;

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final RowMapper<Reservation> rowMapper = (rs, rowNum) -> {
        Reservation reservation = new Reservation();
        reservation.setDinerId(rs.getString("diner_id"));
        reservation.setTableId(rs.getString("table_id"));
        reservation.setStartTime(rs.getTimestamp("start_time").toLocalDateTime());
        reservation.setEndTime(rs.getTimestamp("end_time").toLocalDateTime());
        return reservation;
    };

    public ReservationRepository(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public List<Reservation> getReservationForDiners(LocalDateTime startTime, LocalDateTime endTime, List<String> dinerIds) {
        final String query = "SELECT * FROM reservation WHERE (start_time >= :startTime or end_time <= :endTime) and diner_id in (:dinerIds)";

        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("startTime", startTime);
        parameters.addValue("endTime", endTime);
        parameters.addValue("dinerIds", dinerIds);

        return this.namedParameterJdbcTemplate.query(query, parameters, rowMapper);
    }

    public void createReservations(List<Reservation> reservations) {
        String query = "INSERT INTO reservation (table_id, start_time, end_time, diner_id) VALUES (?, ?, ?, ?)";
        jdbcTemplate.batchUpdate(query, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Reservation reservation = reservations.get(i);
                ps.setString(1, reservation.getTableId());
                ps.setTimestamp(2, Timestamp.valueOf(reservation.getStartTime()));
                ps.setTimestamp(3, Timestamp.valueOf(reservation.getEndTime()));
                ps.setString(4, reservation.getDinerId());
            }

            @Override
            public int getBatchSize() {
                return reservations.size();
            }
        });
    }

    public List<String> checkExistingReservation(List<String> tableIds, LocalDateTime startTime, LocalDateTime endTime) {
        String query = "SELECT DISTINCT table_id FROM reservation WHERE (start_time >= :startTime or end_time <= :endTime) and table_id in (:tableIds)";

        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("startTime", startTime);
        parameters.addValue("endTime", endTime);
        parameters.addValue("tableIds", tableIds);

        return this.namedParameterJdbcTemplate.queryForList(query, parameters, String.class);
    }

    public void deleteReservation(String reservationId) {
        String query = "DELETE FROM reservation where id = ?";
        jdbcTemplate.update(query, reservationId);
    }

    public RowMapper<Reservation> getRowMapper() {
        return this.rowMapper;
    }
}
