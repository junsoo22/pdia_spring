package com.example.demo.product;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductControllerTest {

    @Test
    void getProducts() {
        ProductController productController=new ProductController(new ProductModel());
        System.out.println("productController.getProducts() = " + productController.getProducts());
    }
}