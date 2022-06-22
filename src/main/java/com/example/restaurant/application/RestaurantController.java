package com.example.restaurant.application;

import com.example.restaurant.application.dto.RestaurantDTO;
import com.example.restaurant.domain.Restaurant;
import com.example.restaurant.persistence.RestaurantRepository;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
public class RestaurantController {

    private RestaurantRepository restaurantRepository;

    public RestaurantController ( RestaurantRepository repository){this.restaurantRepository = repository;}

    public RestaurantDTO createRestaurant (RestaurantDTO restaurantDTO)throws Exception{
        Restaurant restaurant = new Restaurant(restaurantDTO);
        this.restaurantRepository.save(restaurant);
        return new RestaurantDTO(restaurant);
    }

    public RestaurantDTO getRestaurant (String restaurantId){
        Restaurant restaurant = restaurantRepository.findById(restaurantId).get();
        return new RestaurantDTO(restaurant);
    }

    public RestaurantDTO updateChannel (String restaurantId, RestaurantDTO restaurantToUpdate) throws Exception {

        Restaurant restaurant = restaurantRepository.findById(restaurantId).get();
        restaurant.updateRestaruant(restaurantToUpdate);
        this.restaurantRepository.save(restaurant);
        return new RestaurantDTO(restaurant);

    }
    public void deleteRestaurant(String restaurantId) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId).get();
        restaurantRepository.delete(restaurant);
    }
    public void deleteAllRestaurants() {
        restaurantRepository.deleteAll();
    }

    public List<RestaurantDTO> getAllRestaurants() {
        List<Restaurant> result = new ArrayList<>();

        Iterator<Restaurant> iterator = this.restaurantRepository.findAll().iterator();
        iterator.forEachRemaining(result::add);

        return result.stream().map(x -> new RestaurantDTO(x)).toList();
    }

}
