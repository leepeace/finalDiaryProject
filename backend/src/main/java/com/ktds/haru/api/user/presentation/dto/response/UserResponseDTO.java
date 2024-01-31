package com.ktds.haru.api.user.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDTO {

    //아이디
    private String userId;

    //비밀번호
    private String password;

    //닉네임
    private String nickName;

}
