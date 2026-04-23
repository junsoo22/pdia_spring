package com.example.demo.product;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ProductModel {

    //
    private Map<Integer, String> db = new HashMap<>();
    private int Id = 1;

    public ProductModel() {
        System.out.println("Model");
    }

    public List<String> getProducts() {
        return db.entrySet()
                .stream()
                .map(entry -> "상품 ID: " + entry.getKey() + ", 상품 이름: " + entry.getValue())
                .toList();
    }

    public String saveProduct(String name){
        db.put(Id++,name);

        return db.toString();
    }
}
