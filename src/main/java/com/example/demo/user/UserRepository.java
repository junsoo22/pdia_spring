package com.example.demo.user;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@Component
public class UserRepository {

    //DB를 저장하고 꺼내주고 처리하는 책임.
    private Map<String, User> db = new HashMap<>();

    private int id = 1;

    public User save(User user) {
        db.put(user.getUserId(),user);

        return db.get(user.getUserId());
    }

    public boolean existByUserId(String userId) {
        return db.containsKey(userId);
    }

    public Optional<User> findByUserId(String userId) {
        return Optional.ofNullable(db.get(userId));
    }
}
