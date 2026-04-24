package com.example.demo.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductService {

    //DB를 저장하고 꺼내주고 처리하는 책임.
    private final ProductRepository productRepository;

    //데이터 연산
    private final int exchangeRate=1450;


    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
        System.out.println("Model");
    }

    public List<String> getProducts() {
        return productRepository.getProducts();
    }


    public Product saveProduct(Product product){
        product.setPriceByDollar(product.getPrice()/exchangeRate);
        productRepository.saveProduct(product);
        return product;
    }
}