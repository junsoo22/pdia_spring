package com.example.demo.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserSignupRes signup(UserSignUpReq userSignUpReq) {

        User newUser=userSignUpReq.toEntity();    //Entity로 바꿔서 레포지토리에 던짐
        User savedUser=userRepository.save(newUser);
        return UserSignupRes.from(savedUser);   //Entity로부터 dto로 변환해서 반환
    }
}
