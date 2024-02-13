package com.ktds.haru.api.user.service.impl;

import com.ktds.haru.api.user.persistence.repository.UserRepository;
import com.ktds.haru.api.user.presentation.dto.request.LoginRequestDTO;
import com.ktds.haru.api.user.presentation.dto.request.UserRequestDTO;
import com.ktds.haru.api.user.presentation.dto.response.UserResponseDTO;
import com.ktds.haru.api.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    
    //회원가입
    @Override
    public boolean signUp(UserRequestDTO user){
        int result = userRepository.signUp(user);

        //회원가입에 실패한 경우
        if(result <= 0){
            return false;
        }

        return true;
    }

    //로그인
    @Override
    public boolean login(LoginRequestDTO loginRequestDTO){
        UserResponseDTO userResponseDTO = userRepository.login(loginRequestDTO);

        //기존 회원 정보가 없는 경우
        if(userResponseDTO == null){
            return false;
        }

        return true;
    }



    //아이디 중복 체크
    @Override
    public boolean checkValidateId(String userId){
        String checkResult = userRepository.checkValidateId(userId);

        //아이디가 중복된 경우
        if(checkResult != null){
            return true;
        }
        //아이디가 중복되지 않은 경우
        return false;
    }


    //사용자 아이디로 pk id 가져오기
    public int getUserIdById(String loginId){
        return userRepository.getUserId(loginId);
    }
}
