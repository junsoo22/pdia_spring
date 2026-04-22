package com.example.demo.injection;


import org.springframework.stereotype.Component;

@Component
public class ParentModel {

    ParentModel(){
        System.out.println("parentModel");
    }

    public String getData(){
        return "";
    }
}
