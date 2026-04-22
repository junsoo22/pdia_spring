package com.example.demo.injection;

import org.springframework.stereotype.Component;

@Component
public class ChildBModel extends ParentModel{

    ChildBModel(){
        System.out.println("ChildB");
    }

    public String getData() {
        return "Data B";
    }
}
