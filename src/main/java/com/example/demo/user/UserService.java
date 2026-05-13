package com.example.demo.user;

import com.example.demo.exception.DuplicatedUserException;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.exception.WrongLoginRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserSignupRes signup(UserSignUpReq userSignUpReq){
        /**
         * req에서 userID -> repository에게 중복된게 있는지 판단만
         * 1) 있으면(중복이면) ->
         * 2) 없으면 (중복 X) ->
         */

        if(isDuplicatedUserId(userSignUpReq)){      //중복이면
            throw new DuplicatedUserException("중복된 사용자");
        }

        User newUser=userSignUpReq.toEntity();    //Entity로 바꿔서 레포지토리에 던짐
        User savedUser=userRepository.save(newUser);
        return UserSignupRes.from(savedUser);   //Entity로부터 dto로 변환해서 반환
    }

    private boolean isDuplicatedUserId(UserSignUpReq userSignUpReq) {
        return userRepository.existByUserId(userSignUpReq.getUserId());
    }

    /*
    1. 아이디를 가진 유저를 찾는다.
    2. 비밀번호가 맞는지 판단한다.
    3. 로그인 시켜준다. (return userId)
    => 각각 기능 하나다. 1,2번을 메서드화 한다.
     */
    public String login(UserLoginReq userLoginReq) {
        String userId = userLoginReq.getId();

        //1
        User loginUser = userRepository.findByUserId(userId)
                .orElseThrow(()->new UserNotFoundException("사용자 없음"));

        //2.
        validatePassword(userLoginReq, loginUser);

        return loginUser.getUserId();
    }

    private static void validatePassword(UserLoginReq userLoginReq, User loginUser) {
        if (!userLoginReq.getPassword().equals(loginUser.getPassword())) {
            throw new WrongLoginRequestException("비밀번호 오류");
        }
    }
}
