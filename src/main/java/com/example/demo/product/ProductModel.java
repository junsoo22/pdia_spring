package com.example.demo.product;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ProductModel {

    //
    private Map<Integer, String> db = new HashMap<>();
    private int Id = 1;

    public ProductModel() {
        System.out.println("Model");
    }

    public String getProduct(){
        return db.values().toString();
    }

    public String saveProduct(String name){
        db.put(Id++,name);

        return db.toString();
    }
}
