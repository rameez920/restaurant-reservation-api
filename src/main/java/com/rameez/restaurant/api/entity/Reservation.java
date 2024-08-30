package com.rameez.restaurant.api.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Reservation {

    LocalDateTime startTime;
    LocalDateTime endTime;
    String tableId;
    String dinerId;

    public Reservation() {}

    public Reservation(LocalDateTime startTime, LocalDateTime endTime, String tableId, String dinerId) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.tableId = tableId;
        this.dinerId = dinerId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    public String getDinerId() {
        return dinerId;
    }

    public void setDinerId(String dinerId) {
        this.dinerId = dinerId;
    }
}
