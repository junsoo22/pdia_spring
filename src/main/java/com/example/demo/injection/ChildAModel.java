package com.example.demo.injection;

import org.springframework.stereotype.Component;

@Component
public class ChildAModel extends ParentModel{

    ChildAModel() {
        System.out.println("ChildA");
    }

    public String getData() {

        return "DataA";
    }
}
