package com.example.demo.product;


import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import static java.lang.Thread.sleep;

@Component     //new Product()로 객체 생성하지 말고 스프링이 객체 생성 해주도록
public class ProductModel {


    public ProductModel() {
        System.out.println("Model");
    }

    public String getProduct(){
        return "sneakers";
    }
}
