package com.example.demo.services;

import java.util.*;

import org.springframework.stereotype.Service;

import com.example.demo.entity.UserEntity;

@Service
public class UserImpl implements UserServices {

    private final Map<Long, UserEntity> store = new HashMap<>();
    private long counter = 1;

    @Override
    public UserEntity insertUser(UserEntity user) {
      
        if (user.getId() == null) {
            user.setId(counter++);
        }
        store.put(user.getId(), user);
        return user;
    }

    @Override
    public List<UserEntity> getAllUser() {
        return new ArrayList<>(store.values());
    }

    @Override
    public Optional<UserEntity> getOneUser(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public void deleteUser(Long id) {
        store.remove(id);
    }
}