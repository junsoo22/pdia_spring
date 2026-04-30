package com.example.demo.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class UserSignUpReq {
     private String userId;
     private String password;
     private String name;
     private Date birthDay;
     private String phoneNumber;

    public User toEntity() {

        return User.builder().
                userId(userId)
                .password(password)
                .name(name)
                .birthDay(birthDay)
                .contact(phoneNumber)
                .build();
    }

    @Override
    public String toString() {
        return "UserSignUpReq{" +
                "userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", birthDay=" + birthDay +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
