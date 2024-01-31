package com.ktds.haru.api.user.service;

public interface UserService {
    
    //회원가입
    public boolean signUp();

    //로그인


    //아이디 중복 체크
    public boolean checkValidateId(String userId);
    
}
