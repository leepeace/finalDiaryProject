package com.ktds.haru.api.user.presentation.controller;

import com.ktds.haru.api.common.BaseResponse;
import com.ktds.haru.api.user.presentation.dto.request.LoginRequestDTO;
import com.ktds.haru.api.user.presentation.dto.request.UserRequestDTO;
import com.ktds.haru.api.user.presentation.validator.UserValidator;
import com.ktds.haru.api.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@Tag(name = "user controller")
@Slf4j
public class UserController {

    private final UserService userService;
    private final UserValidator userValidator;

    /*
    * 회원가입
    * */
    @PostMapping("/sign-up")
    @Operation(summary = "회원가입", description = "사용자 정보를 받아 회원가입을 합니다.")
    public BaseResponse<?> signUp(@RequestBody UserRequestDTO userRequestDTO){
        //NULL 체크
        userValidator.validateUserRequestDTO(userRequestDTO);

        boolean result = userService.signUp(userRequestDTO);

        if(!result){
            return new BaseResponse<>(false, HttpStatus.UNPROCESSABLE_ENTITY.value(), "회원가입 실패");
        }


        return new BaseResponse<>(true, HttpStatus.OK.value(), "회원가입 성공");
    }
    
    /*
    * 로그인
    * */
    @PostMapping("/login")
    @Operation(summary = "로그인", description = "아이디와 비밀번호로 로그인을 합니다.")
    public BaseResponse<?> login(@RequestBody LoginRequestDTO loginRequestDTO){

        //NOT NULL 검증
        userValidator.validateLoginRequestDTO(loginRequestDTO);
        
        boolean result = userService.login(loginRequestDTO);
        
        //로그인 정보가 없는 경우
        if(!result){
            return new BaseResponse<>(false, HttpStatus.NOT_FOUND.value(), "로그인 정보 없음");

        }

        return new BaseResponse<>(true, HttpStatus.OK.value(), "로그인 정보 있음");
    }

    /*
    * 아이디 중복 체크
    * */
    @GetMapping("/check-id")
    @Operation(summary = "아이디 중복체크", description = "사용자가 입력한 아이디의 중복 체크 기능입니다.")
    public BaseResponse<?> checkValidateId(@RequestParam String userId){

        //아이디가 중복된 경우
        if(!userService.checkValidateId(userId)){
            return new BaseResponse<>(false, HttpStatus.CONFLICT.value(), "아이디 중복 있음");
        }

        return new BaseResponse<>(true, HttpStatus.OK.value(), "아이디 중복 없음");
    }

}
