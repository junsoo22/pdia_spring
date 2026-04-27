package com.example.demo.product;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
public class Product {

    private String name;
    private int price;
    private int priceByDollar;

}
