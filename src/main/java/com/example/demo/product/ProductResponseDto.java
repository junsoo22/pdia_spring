package com.example.demo.product;


import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ProductResponseDto {

    private int id;
    private String name;
    private int priceKRW;
    private int priceUSD;

    public static ProductResponseDto from(Product foundProduct){

        return ProductResponseDto.builder().
                id(foundProduct.getId())
                .name(foundProduct.getName())
                .priceKRW(foundProduct.getPriceKRW())
                .priceUSD(foundProduct.getPriceUSD())
                .build();
    }
}
