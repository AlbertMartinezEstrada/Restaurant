package com.example.restaurant.application;

import com.example.restaurant.application.dto.RestaurantDTO;
import com.example.restaurant.application.dto.TableDTO;
import com.example.restaurant.domain.Restaurant;
import com.example.restaurant.domain.Table;
import com.example.restaurant.persistence.RestaurantRepository;
import com.example.restaurant.persistence.TableRepository;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
public class TableController {
    private TableRepository tableRepository;
    private RestaurantRepository restaurantRepository;

    public TableController(TableRepository tableRepository, RestaurantRepository restaurantRepository){
        this.tableRepository = tableRepository;
        this.restaurantRepository = restaurantRepository;
    }

    public TableDTO createTable(String restaurantId, TableDTO tableDTO) throws Exception{
        Table table = new Table(tableDTO);
        Restaurant restaurant = restaurantRepository.findById(restaurantId).get();
        restaurant.addTable(table);
        table.setRestaurant(restaurant);
        tableRepository.save(table);
        return new TableDTO(table);
    }

    public TableDTO createTable (TableDTO tableDTO)throws Exception{
        Table table = new Table(tableDTO);
        this.tableRepository.save(table);
        return new TableDTO(table);
    }

    public TableDTO getTable (String tableId){
        Table table = tableRepository.findById(tableId).get();
        return new TableDTO(table);
    }

    public TableDTO updateTable (String restaurantId, String tableId, TableDTO tableToUpdate) throws Exception {
        Table table = this.tableRepository.findById(tableId).get();
        table.checkValidRestaurant(restaurantId);
        table.updateTable(tableToUpdate);
        tableRepository.save(table);
        return new TableDTO(table);
    }
    public void deleteTable(String tableId) {
        Table table = tableRepository.findById(tableId).get();
        tableRepository.delete(table);
    }
    public void deleteAllRestaurants() {
        tableRepository.deleteAll();
    }

    public List<TableDTO> getAllTables(String restaurantId) {
        List<Table> result = new ArrayList<>();
        Restaurant restaurant = restaurantRepository.findById(restaurantId).get();
        Iterator<Table> iterator = this.tableRepository.findAllByRestaurant(restaurant).iterator();
        iterator.forEachRemaining(result::add);
        return result.stream().map(x -> new TableDTO(x)).toList();
    }

}
