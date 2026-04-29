package com.example.demo.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Component
@Service
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

    public int saveProduct(ProductRequestDto productDto){

        //DTO: 이름, 원화,
        //Entity: 이름, 원화, 달러
        //1. Dto에 굳이 달러 계산을 해서 entity로 값을 줄 필요가 있나?
        //DTO는 달러가 필요 없는데..
        productDto.setPriceByDollar(productDto.getPrice() / exchangeRate);
        LocalDate today= LocalDate.now();
        productDto.setCreatedAt(today);

        Product product = productDto.toEntity();

        //2. Entity는 데이터 무결성 떄문이라ㅣ며
        //연산 넣는 건 좀 부담스러움.
        // Entity 밖에서 연산 다 해서, Entity 변환

        return productRepository.saveProduct(product);
    }

    public ProductResponseDto getProduct(int productId, String lang) throws EnumConstantNotPresentException {
        Product foundProduct = productRepository.getProduct(productId);

        //Enum을 가지고 판단, Enum에 포함되었냐 안되었냐.
        for (Language language:Language.values()){
            if (language.getLangType().equals(lang)){
                ProductResponseDto responseDto
                        = ProductResponseDto.from(foundProduct, lang);

                return responseDto;
            }
        }
        throw new IllegalArgumentException();
    }
}