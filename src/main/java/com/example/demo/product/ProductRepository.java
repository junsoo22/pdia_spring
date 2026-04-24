package com.example.demo.product;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ProductRepository {

    //DB를 저장하고 꺼내주고 처리하는 책임.
    private Map<Integer, Product> db = new HashMap<>();
    private int Id = 1;

    public List<String> getProducts() {
        return db.entrySet()
                .stream()
                .map(entry -> "상품 ID: " + entry.getKey() + ", 상품 이름: " + entry.getValue().getName()+", 상품 가격: "+entry.getValue().getPrice()+"달러")
                .toList();
    }

    public Product saveProduct(Product product){
        db.put(Id++,product);

        return product;
    }

}
