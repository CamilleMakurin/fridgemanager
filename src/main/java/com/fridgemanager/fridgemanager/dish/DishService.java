package com.fridgemanager.fridgemanager.dish;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DishService {

    @Autowired
    private DishRepository repository;

    public Optional<Dish> getDish(String dishName) {
        return Optional.ofNullable(repository.get(dishName));
    }

    public void createDish(Dish dish) {
        repository.add(dish);
    }

    public void deleteDish(String dishName) {
        repository.delete(dishName);
    }

    public void updateDish(Dish dish) {
        repository.update(dish);
    }
}
