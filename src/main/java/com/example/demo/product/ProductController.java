package com.example.demo.product;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    Product products=new Product();

    ProductController() {
        System.out.println("초기화 중임");
    }

    //전체 상품 조회
    @GetMapping("/products")
    public String getProducts(){
        return products.getProduct();
    }
}
