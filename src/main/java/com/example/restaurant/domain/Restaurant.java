package com.example.restaurant.domain;

import com.example.restaurant.application.dto.RestaurantDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Restaurant {
    public final static int MAX_CAPACITY = 24;
    public final static int MAX_CAPACITY_IN_TABLE = 6;
    public final static int MAX_TABLES = 4;
    private int currentCapacity = 0;

    private String id = UUID.randomUUID().toString();
    private String name;
    private List<Table> tables = new ArrayList<>();

    public Restaurant(){

    }

    public Restaurant (String name){
        this.name = name;
    }

    public Restaurant (RestaurantDTO restaurantDTO)throws Exception{
        if (restaurantDTO == null) throw new Exception();

        this.name = restaurantDTO.getName();
    }

    public void addTable(Table table) throws Exception{
        if (table == null) throw new Exception();
        this.tables.add(table);
    }

    public String getId() { return id;}

    public String getName(){return name;}

    public void updateRestaruant (RestaurantDTO restaurantToUpdate) throws Exception{
        if (restaurantToUpdate == null) throw new Exception();
        this.name = restaurantToUpdate.getName();
    }




}
