package com.example.demo.user;

import lombok.Builder;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Builder
@Getter
public class User {

    private String id;
    private String password;
    private String name;
    private String birth;
    private String phoneNumber;


}
