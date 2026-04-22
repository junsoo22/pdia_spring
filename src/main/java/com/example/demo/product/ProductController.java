package com.example.demo.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private ProductModel products;

    public ProductController(){
        System.out.println("Controller");
        System.out.println(products);
    }

    //전체 상품 조회
    @GetMapping("/products")
    public String getProducts(){
        return products.getProduct();
    }
}
