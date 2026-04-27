package com.example.demo.product;

import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@NoArgsConstructor
public class ProductDto {

    private String name;
    private int price;
    private int priceByDollar;

}
