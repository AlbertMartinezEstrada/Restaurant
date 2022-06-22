package com.example.restaurant.persistence;

import com.example.restaurant.domain.Restaurant;
import com.example.restaurant.domain.Table;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableRepository extends CrudRepository<Table, String> {
    Iterable<Table> findAllByRestaurant (Restaurant restaurant);

    Iterable<Table> findAllById(String id);
}
