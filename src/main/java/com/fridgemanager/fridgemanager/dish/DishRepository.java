package com.fridgemanager.fridgemanager.dish;

import com.fridgemanager.fridgemanager.dish.Dish;
import com.fridgemanager.fridgemanager.repository.InMemoryRepository;
import org.springframework.stereotype.Repository;

@Repository
public class DishRepository extends InMemoryRepository<Dish> {

    public static final String REPOSITORY_NAME = "DISH";

    @Override
    public String getStorage() {
        return REPOSITORY_NAME;
    }
}
