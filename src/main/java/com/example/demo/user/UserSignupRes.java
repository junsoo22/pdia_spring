package com.example.demo.user;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserSignupRes {

    private String userId;
    private String name;

    public static UserSignupRes from(User user) {
        return UserSignupRes.builder()
                .userId(user.getUserId())
                .name(user.getName())
                .build();
    }
}
