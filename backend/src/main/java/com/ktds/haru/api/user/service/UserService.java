package com.ktds.haru.api.user.service;

import com.ktds.haru.api.user.presentation.dto.request.LoginRequestDTO;
import com.ktds.haru.api.user.presentation.dto.request.UserRequestDTO;

public interface UserService {
    //회원가입
    boolean signUp(UserRequestDTO user);

    //로그인
    boolean login(LoginRequestDTO loginRequestDTO);

    //아이디 중복 체크
    boolean checkValidateId(String userId);
}
