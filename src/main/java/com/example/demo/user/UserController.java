package com.example.demo.user;

import lombok.RequiredArgsConstructor;
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

        if(isValidPassword(userSignUpReq)){
            UserSignupRes userResponseDto=userService.signup(userSignUpReq);
            return ResponseEntity.status(HttpStatus.CREATED).body(userResponseDto);
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }


    /**
     * Req: ID, PW
     * Res: ID
     */
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserLoginReq userLoginReq){
        logger.info(userLoginReq.toString());
        return ResponseEntity.status(HttpStatus.OK).body(userService.login(userLoginReq));
    }

    private static boolean isValidPassword(UserSignUpReq userSignUpReq) {
        return userSignUpReq.getPassword().length() >= 8;
    }
}
