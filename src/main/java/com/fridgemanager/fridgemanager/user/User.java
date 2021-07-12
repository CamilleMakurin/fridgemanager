package com.fridgemanager.fridgemanager.user;

import com.fridgemanager.fridgemanager.StoredObject;
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
