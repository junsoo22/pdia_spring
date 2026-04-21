package com.example.demo.product;


import org.springframework.stereotype.Component;

@Component     //new Product()로 객체 생성하지 말고 스프링이 객체 생성 해주도록
public class Product {

    private String product="sneakers";

    public String getProduct(){
        return product;
    }
}
