package com.rameez.restaurant.api.entity;

import java.util.Objects;

public class RestaurantTable {

    private String tableId;

    private String restaurantId;

    private int capacity;


    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RestaurantTable restaurantTable = (RestaurantTable) o;
        return this.tableId.equals(restaurantTable.getTableId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.tableId);
    }
}
