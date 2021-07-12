package com.fridgemanager.fridgemanager.user;

import com.fridgemanager.fridgemanager.repository.InMemoryRepository;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository extends InMemoryRepository<User> {

    public static final String REPOSITORY_NAME = "DISH";

    @Override
    public String getStorage() {
        return REPOSITORY_NAME;
    }
}
