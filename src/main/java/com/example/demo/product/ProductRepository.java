package com.example.demo.product;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Repository
public class ProductRepository {

    //DB를 저장하고 꺼내주고 처리하는 책임.
    private Map<Integer, Product> db = new HashMap<>();

    private int id = 1;

    public List<String> getProducts() {
        return db.entrySet()
                .stream()
                .map(entry -> "상품 ID: " + entry.getKey() + ", 상품 이름: " + entry.getValue().getName()+", 상품 가격: "+entry.getValue().getPriceKRW()+"원 /"+entry.getValue().getPriceUSD()+" 달러")
                .toList();
    }

    public int saveProduct(Product product){
        product.setId(id);
        db.put(id++,product);

        return db.get(id-1).getId();    //DB에서 id값 꺼내기
    }

    public Product getProduct(int productId){
        return db.get(productId);
    }
}
