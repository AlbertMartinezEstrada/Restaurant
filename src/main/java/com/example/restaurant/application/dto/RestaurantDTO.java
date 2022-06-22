package com.example.restaurant.application.dto;

import com.example.restaurant.domain.Restaurant;
import com.example.restaurant.domain.Table;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class RestaurantDTO {

    protected String id;
    protected String name;

    public RestaurantDTO(){}

    public RestaurantDTO(String name){
       this.name=name;
    }
    public RestaurantDTO (Restaurant restaurant){
       this.id = restaurant.getId();
       this.name = restaurant.getName();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
