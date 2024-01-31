package com.ktds.haru.api.user.presentation.controller;

import com.ktds.haru.api.common.BaseResponse;
import com.ktds.haru.api.user.presentation.dto.request.LoginRequestDTO;
import com.ktds.haru.api.user.presentation.dto.request.UserRequestDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@Tag(name = "user controller")
@Slf4j
public class UserController {

    //private final UserService userService;

    /*
    * 회원가입
    * */
    @PostMapping("/sign-up")
    @Operation(summary = "회원가입", description = "사용자 정보를 받아 회원가입을 합니다.")
    public BaseResponse<?> signUp(@RequestBody UserRequestDTO userRequestDTO){
        return null;
    }
    
    /*
    * 로그인
    * */
    @PostMapping("/login")
    @Operation(summary = "로그인", description = "아이디와 비밀번호로 로그인을 합니다.")
    public BaseResponse<?> login(@RequestBody LoginRequestDTO loginRequestDTO){
        return null;
    }

    /*
    * 아이디 중복 체크
    * */
    @PostMapping("/check-id")
    @Operation(summary = "아이디 중복체크", description = "사용자가 입력한 아이디의 중복 체크 기능입니다.")
    public BaseResponse<?> checkValidateId(@RequestBody String userId){
        return null;
    }

}
