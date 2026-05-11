package com.example.demo.user;

import com.example.demo.exception.DuplicatedUserException;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.exception.WrongLoginRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

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

    public String login(UserLoginReq userLoginReq) {
        String userId = userLoginReq.getId();

        try {
            User loginUser = userRepository.findByUserId(userId);
            if (isEquals(userLoginReq, loginUser)) {
                return loginUser.getUserId();
            }
            else{
                throw new WrongLoginRequestException("비밀번호 오류");
            }
        } catch (NullPointerException e) {
            throw new UserNotFoundException("사용자 없음");
        }


    }

    private static boolean isEquals(UserLoginReq userLoginReq, User loginUser) {
        return userLoginReq.getPassword().equals(loginUser.getPassword());
    }
}
