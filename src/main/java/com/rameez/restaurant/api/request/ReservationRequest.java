package com.rameez.restaurant.api.request;

import java.time.LocalDateTime;
import java.util.List;

public class ReservationRequest {

    private List<String> dinerIds;

    private String restaurantId;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    public List<String> getDinerIds() {
        return dinerIds;
    }

    public void setDinerIds(List<String> dinerIds) {
        this.dinerIds = dinerIds;
    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
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
}
