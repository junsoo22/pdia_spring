package com.example.demo.user;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Builder
@Getter
public class User {

    private String userId;
    private String password;
    private String name;
    private Date birthDay;
    private String contact;
//    private Date createdAt;
}
