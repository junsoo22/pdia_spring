package com.example.demo.product;

import lombok.*;

@Getter
@NoArgsConstructor
@Setter
public class ProductDto {

    private String name;
    private int price;
    private int priceByDollar;

    public Product toEntity() {

        Product newProduct = Product.builder().
                name(name)
                .price(price)
                .priceByDollar(priceByDollar)
                .build();
        return newProduct;
    }

}
