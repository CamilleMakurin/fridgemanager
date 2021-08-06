package com.fridgemanager.fridgemanager.storage.domain;

import com.fridgemanager.fridgemanager.dish.Dish;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StoredDish extends StoredItem {

    private String id;
    private Dish dish;

}
