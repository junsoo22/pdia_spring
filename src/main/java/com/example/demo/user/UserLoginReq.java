package com.example.demo.user;

import lombok.Builder;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@Builder
public class UserLoginReq {

    private String id;
    private String password;

    @Override
    public String toString() {
        return "UserLoginReq{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
