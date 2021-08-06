package com.fridgemanager.fridgemanager.product;

import com.fridgemanager.fridgemanager.dish.Dish;
import com.fridgemanager.fridgemanager.repository.InMemoryRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository extends InMemoryRepository<Product> {

    public static final String REPOSITORY_NAME = "PRODUCT";

    @Override
    public String getStorage() {
        return REPOSITORY_NAME;
    }
}
