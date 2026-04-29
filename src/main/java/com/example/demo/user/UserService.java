package com.example.demo.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    public UserResponseDto signup(UserRequestDto userRequestDto) {

        User user=userRequestDto.toEntity();

        return userRepository.signup(user);

    }
}
