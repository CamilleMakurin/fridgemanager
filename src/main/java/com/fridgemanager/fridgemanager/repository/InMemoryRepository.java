package com.fridgemanager.fridgemanager.repository;

import com.fridgemanager.fridgemanager.domain.StoredObject;

import java.util.HashMap;
import java.util.Map;

public abstract class InMemoryRepository<T extends StoredObject> {

    private final Map<String, Map<String, T>> storage = new HashMap<>();

    public abstract String getStorage();


    public void addDish(T object) {
        Map<String, T> storage = getStorage(getStorage());
        storage.put(object.getId(), object);
    }

    public void updateDish(T object) {
        Map<String, T> storage = getStorage(getStorage());
        storage.put(object.getId(), object);
    }

    public void deleteDish(T object) {
        Map<String, T> storage = getStorage(getStorage());
        storage.remove(object.getId());
    }

    private Map<String, T> getStorage(String storageName) {
        return storage.computeIfAbsent(storageName, k -> new HashMap<>());
    }
}
