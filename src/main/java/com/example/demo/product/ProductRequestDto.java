package com.example.demo.product;

import lombok.*;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@Setter
public class ProductRequestDto {
    private String name;
    private int price;
    private int priceByDollar;
    private LocalDate createdAt;

    public Product toEntity() {

        Product newProduct = Product.builder()
                .name(name)
                .priceKRW(price)
                .priceUSD(priceByDollar)
                .createdAt(createdAt)
                .build();
        return newProduct;
    }

}
