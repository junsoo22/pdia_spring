package com.example.demo.user;

import com.example.demo.product.ProductController;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {


    private Logger logger = LoggerFactory.getLogger(UserController.class);  // slf4j(Simple Logging Facade for Java) 인터페이스
    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<UserSignupRes> signup(@RequestBody UserSignUpReq userSignUpReq){
        logger.info(userSignUpReq.toString());
        UserSignupRes userResponseDto=userService.signup(userSignUpReq);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponseDto);
    }
}
