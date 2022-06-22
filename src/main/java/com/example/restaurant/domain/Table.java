package com.example.restaurant.domain;

import com.example.restaurant.application.dto.TableDTO;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.UUID;

public class Table {
    private final int MAX_CAPACITY=6;
    private String id;
    private int actualCapacity;
    private boolean isEmpty;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Restaurant restaurant;

    public Table(){
        this.id = UUID.randomUUID().toString();
        this.actualCapacity = 0;
        this.isEmpty = false;
    }

    public Table(TableDTO tableDTO){
        this.id = UUID.randomUUID().toString();
        this.actualCapacity = tableDTO.getActualCapacity();
        this.isEmpty=tableDTO.getIsEmpty();
    }

    public String getId(){
        return this.id;
    }

    public boolean isEmpty() {
        return this.isEmpty;
    }

    public int getActualCapacity(){
        return this.actualCapacity;
    }

    public void setRestaurant(Restaurant restaurant) throws Exception {
        if (restaurant == null) throw new Exception();
        this.restaurant = restaurant;
    }

    public void joinPeople(int numPeople) throws Exception{
        if(numPeople+actualCapacity>MAX_CAPACITY)
            throw new Exception();
        actualCapacity+=numPeople;
    }

    public void checkValidRestaurant(String restaurantId) throws Exception {
        if (this.restaurant == null) throw new Exception();
        if (!restaurant.getId().equals(restaurantId)) throw new Exception();
    }

    public void updateTable(TableDTO tableToUpdate) throws Exception{
        if (tableToUpdate == null) throw new Exception();
        this.actualCapacity = tableToUpdate.getActualCapacity();
        this.isEmpty = tableToUpdate.getIsEmpty();
    }
}
