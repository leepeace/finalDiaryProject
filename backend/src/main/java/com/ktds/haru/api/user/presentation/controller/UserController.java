package com.ktds.haru.api.user.presentation.controller;

import com.ktds.haru.api.common.BaseResponse;
import com.ktds.haru.api.user.presentation.dto.request.LoginRequestDTO;
import com.ktds.haru.api.user.presentation.dto.request.UserRequestDTO;
import com.ktds.haru.api.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    /*
    * 회원가입
    * */
    public BaseResponse<?> signUp(@RequestBody UserRequestDTO userRequestDTO){
        return null;
    }
    
    /*
    * 로그인
    * */
    @PostMapping("/login")
    public BaseResponse<?> login(@RequestBody LoginRequestDTO loginRequestDTO){
        return null;
    }

}
