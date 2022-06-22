package com.example.restaurant.application.dto;
import com.example.restaurant.domain.Table;

public class TableDTO {
    protected String id;
    protected int actualCapacity;
    protected boolean isEmpty;

    public TableDTO (){

    }

    public TableDTO (Table table){
        this.id = table.getId();
        this.actualCapacity = table.getActualCapacity();
        this.isEmpty = table.isEmpty();
    }

    public int getActualCapacity() {
        return this.actualCapacity;
    }

    public boolean getIsEmpty() {
        return this.isEmpty;
    }
}
