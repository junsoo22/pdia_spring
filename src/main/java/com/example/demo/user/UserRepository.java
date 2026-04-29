package com.example.demo.user;


import com.example.demo.product.Product;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepository {

    //DB를 저장하고 꺼내주고 처리하는 책임.
    private Map<Integer, User> db = new HashMap<>();

    private int id = 1;


    public UserResponseDto signup(User user) {

        db.put(id,user);
        User saved=db.get(id++);

        return UserResponseDto.from(saved);

    }
}
