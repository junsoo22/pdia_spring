package com.example.demo.product;


import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ProductResponseDto {

    private int id;
    private String name;
    private int price;          //원화 or 달러
    private String currency;    //"KRW" or "USD"

    public static ProductResponseDto from(Product foundProduct, String lang){

        if (lang.equals("ko")){
            return ProductResponseDto.builder()
                    .id(foundProduct.getId())
                    .name(foundProduct.getName())
                    .price(foundProduct.getPriceKRW())
                    .currency("KRW")
                    .build();
        }

        return ProductResponseDto.builder()
                .id(foundProduct.getId())
                .name(foundProduct.getName())
                .price(foundProduct.getPriceUSD())
                .currency("USD")
                .build();

//        return ProductResponseDto.builder().
//                id(foundProduct.getId())
//                .name(foundProduct.getName())
//                .price(currency.equals("KRW") ? foundProduct.getPriceKRW(): foundProduct.getPriceUSD())
//                .currency(currency)
//                .build();
    }
}
