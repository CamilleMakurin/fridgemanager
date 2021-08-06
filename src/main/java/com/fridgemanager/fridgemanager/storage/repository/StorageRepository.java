package com.fridgemanager.fridgemanager.storage.repository;

import com.fridgemanager.fridgemanager.repository.InMemoryRepository;
import com.fridgemanager.fridgemanager.storage.domain.Storage;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class StorageRepository extends InMemoryRepository<Storage> {

    public static final String REPOSITORY_NAME = "STORAGE";

    @Override
    public String getStorage() {
        return REPOSITORY_NAME;
    }

    public Storage getStorageByUser(String userName) {
        return get(userName);
    }
}
