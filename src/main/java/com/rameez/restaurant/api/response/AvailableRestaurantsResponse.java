package com.rameez.restaurant.api.response;

import com.rameez.restaurant.api.entity.Restaurant;

import java.util.List;

public class AvailableRestaurantsResponse {

    private String message;

    private List<Restaurant> restaurants;


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }
}
