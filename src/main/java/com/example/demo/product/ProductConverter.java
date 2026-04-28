package com.example.demo.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {

    public Product getProduct(ProductDto productDto, int exchangeRate) {

        Product newProduct = Product.builder().
                name(productDto.getName())
                .price(productDto.getPrice())
                .priceByDollar(productDto.getPrice() / exchangeRate)
                .build();
        return newProduct;
    }
}
