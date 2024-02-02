package com.ktds.haru.api.user.presentation.validator;

import com.ktds.haru.api.common.CommonValidator;
import com.ktds.haru.api.user.presentation.dto.request.LoginRequestDTO;
import com.ktds.haru.api.user.presentation.dto.request.UserRequestDTO;
import org.springframework.stereotype.Component;

@Component
public class UserValidator extends CommonValidator {

    public void validateLoginRequestDTO(LoginRequestDTO loginRequestDTO){
        checkStringType(loginRequestDTO.getId(), "아이디");
        checkStringType(loginRequestDTO.getPwd(), "비밀번호");
    }

    public void validateUserRequestDTO(UserRequestDTO userRequestDTO){
        checkStringType(userRequestDTO.getId(), "아이디");
        checkStringType(userRequestDTO.getPwd(), "비밀번호");
        checkStringType(userRequestDTO.getNickname(), "닉네임");
    }

}
