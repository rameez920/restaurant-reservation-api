package com.rameez.restaurant.api.request;

import java.time.LocalDateTime;
import java.util.List;

public class ReservationRequest {

    private List<String> dinerIds;

    private String restaurantId;

    private LocalDateTime startTime;


    private String tableId;

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


    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }
}
