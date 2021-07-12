package com.fridgemanager.fridgemanager.user;

import com.fridgemanager.fridgemanager.domain.Recipe;
import com.fridgemanager.fridgemanager.domain.StoredObject;
import lombok.Data;

@Data
public class User implements StoredObject {

    private String id;
    private String name;

    @Override
    public String getId() {
        return this.name;
    }
}
