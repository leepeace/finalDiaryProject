package com.ktds.haru.api.user.service;

import com.ktds.haru.api.user.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    
    //회원가입
    public boolean signUp(){
        return false;
    }

    //로그인
    public boolean login(){
        return false;
    }



    //아이디 중복 체크
    public boolean checkValidateId(String userId){
        String checkResult = userRepository.checkValidateId(userId);

        //아이디가 중복된 경우
        if(checkResult == null){
            return false;
        }
        //아이디가 중복되지 않은 경우
        return true;
    }
    
}
