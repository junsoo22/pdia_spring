package com.example.demo.user;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserResponseDto {

    private String id;
    private String name;

    public static UserResponseDto from(User user) {


        return UserResponseDto.builder()
                .id(user.getId())
                .name(user.getName())
                .build();
    }
}
