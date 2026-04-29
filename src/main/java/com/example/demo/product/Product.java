package com.example.demo.product;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Builder
@Getter
@Setter
public class Product {

    private int id;
    private String name;
    private int priceKRW;
    private int priceUSD;
    private LocalDate createdAt;

}
