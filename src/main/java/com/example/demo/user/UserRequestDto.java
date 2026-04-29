package com.example.demo.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDto {
     private String id;
     private String password;
     private String name;
     private String birth;
     private String phoneNumber;

    public User toEntity() {
        User newUser = User.builder().
                id(id)
                .password(password)
                .name(name)
                .birth(birth)
                .phoneNumber(phoneNumber)
                .build();

        return newUser;
    }
}
