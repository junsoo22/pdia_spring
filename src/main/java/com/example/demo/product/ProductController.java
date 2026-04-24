package com.example.demo.product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;
    private Logger logger = LoggerFactory.getLogger(ProductController.class);  // slf4j(Simple Logging Facade for Java) 인터페이스

    @Autowired     //생성자 하나 있을 때, 생략 가능
    public ProductController(ProductService productModel){
        System.out.println("Controller");
        System.out.println(productModel);
        this.productService =productModel;
    }

    //전체 상품 조회
    @GetMapping("/products")
    public List<String> getProducts(){
        return productService.getProducts();
    }


    //1단계: 상품명, 상품 가격도 추가로 받음.
    //2단계: DB에 저장할 땐 달러로 바꿔서 저장되어야 한다. (환율 1달러 = 1450원)
    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product){
        logger.debug("product.name:{} ", product.getName());
        logger.debug("product.price:{}", product.getPrice());
        logger.debug("product",product);
        return productService.saveProduct(product);
    }
}
