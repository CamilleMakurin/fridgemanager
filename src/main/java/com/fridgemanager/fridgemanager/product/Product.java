package com.fridgemanager.fridgemanager.product;

import com.fridgemanager.fridgemanager.StoredObject;
import lombok.Data;

@Data
public class Product implements StoredObject {

    private String name;

    @Override
    public String getId() {
        return name;
    }
}
