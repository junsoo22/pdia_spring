package com.example.demo.product;


import lombok.Builder;
import lombok.Getter;
import java.time.LocalDate;

@Builder
@Getter
public class Product {

    private int id;
    private String name;
    private int priceKRW;
    private int priceUSD;
    private LocalDate createdAt;

}
