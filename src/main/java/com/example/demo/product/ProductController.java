package com.example.demo.product;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    // Controller 태어날 때마다 product가 같이 태어남... 종속되어서 태어남.
    // -> 객체 생성을 스프링이 해주도록 만들기 -> Product 모델에 @Component
    Product products;

    ProductController(Product products) {
        this.products=products;    //자바처럼 생성자에 초기화해줌.
    }

    //전체 상품 조회
    @GetMapping("/products")
    public String getProducts(){
        return products.getProduct();
    }
}
