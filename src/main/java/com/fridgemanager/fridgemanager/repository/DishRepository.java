package com.fridgemanager.fridgemanager.repository;

import com.fridgemanager.fridgemanager.domain.Dish;

public class DishRepository extends InMemoryRepository<Dish>{


    public static final String REPOSITORY_NAME = "DISH";

    public void addDish(Dish dish){

    }

    public void updateDish(Dish dish){

    }

    public void deleteDish(Dish dish){

    }

    @Override
    public String getStorage() {
        return REPOSITORY_NAME;
    }
}
