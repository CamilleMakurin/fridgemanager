package com.fridgemanager.fridgemanager.domain;

import lombok.Data;

@Data
public class Dish implements StoredObject {

    private String id;
    private String name;
    private Recipe recipe;


    @Override
    public String getId() {
        return this.id;
    }
}
