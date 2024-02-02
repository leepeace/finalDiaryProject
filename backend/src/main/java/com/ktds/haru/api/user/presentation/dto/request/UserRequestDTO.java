package com.ktds.haru.api.user.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDTO {

    //아이디
    private String id;

    //비밀번호
    private String pwd;

    //닉네임
    private String nickname;

}
