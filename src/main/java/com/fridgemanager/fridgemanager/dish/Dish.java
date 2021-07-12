package com.fridgemanager.fridgemanager.dish;

import com.fridgemanager.fridgemanager.domain.Recipe;
import com.fridgemanager.fridgemanager.domain.StoredObject;
import lombok.Data;

@Data
public class Dish implements StoredObject {

    private String id;
    private String name;
    private Recipe recipe;


    @Override
    public String getId() {
        return this.name;
    }
}
