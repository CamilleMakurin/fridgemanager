package com.fridgemanager.fridgemanager.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserService {

    @Autowired
    private UserRepository repository;

    public Optional<User> getUser(String userName) {
        return Optional.ofNullable(repository.get(userName));
    }

    public void createUser(User user) {
        repository.add(user);
    }

    public void deleteUser(String userName) {
        repository.delete(userName);
    }

    public void updateUser(User user) {
        repository.update(user);
    }
}
