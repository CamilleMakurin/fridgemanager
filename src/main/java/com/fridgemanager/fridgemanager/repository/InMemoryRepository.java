package com.fridgemanager.fridgemanager.repository;

import com.fridgemanager.fridgemanager.StoredObject;

import java.util.HashMap;
import java.util.Map;

public abstract class InMemoryRepository<T extends StoredObject> {

    private final Map<String, Map<String, T>> storage = new HashMap<>();

    public abstract String getStorage();

    public void add(T object) {
        Map<String, T> storage = getStorage(getStorage());
        storage.put(object.getId(), object);
    }

    public void update(T object) {
        Map<String, T> storage = getStorage(getStorage());
        storage.put(object.getId(), object);
    }

    public void delete(String objectId) {
        Map<String, T> storage = getStorage(getStorage());
        storage.remove(objectId);
    }

    public T get(String objectId) {
        Map<String, T> storage = getStorage(getStorage());
        return storage.get(objectId);
    }

    public Map<String, T> getStorage(String storageName) {
        return storage.computeIfAbsent(storageName, k -> new HashMap<>());
    }
}
