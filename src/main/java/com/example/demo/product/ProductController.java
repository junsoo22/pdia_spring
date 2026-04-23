package com.example.demo.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<String> getProducts(){
        return productModel.getProducts();
    }


    //1단계: 상품명, 상품 가격도 추가로 받음.
    @PostMapping("/products")
    public ProductRequest registerProduct(@RequestBody ProductRequest request){
        System.out.println("request = " + request);
        return productModel.saveProduct(request);
    }
}
