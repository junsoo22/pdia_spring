package com.example.demo.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    private final ProductModel productModel;

    @Autowired     //생성자 하나 있을 때, 생략 가능
    public ProductController(ProductModel productModel){
        System.out.println("Controller");
        System.out.println(productModel);
        this.productModel=productModel;
    }

    //전체 상품 조회
    @GetMapping("/products")
    public String getProducts(){
        return productModel.getProduct();
    }

    @PostMapping("/products")
    public String registerProduct(@RequestBody String name){
        return productModel.saveProduct(name);
    }
}
