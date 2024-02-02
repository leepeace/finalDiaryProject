package com.ktds.haru.api.school.presentation.dto.request;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Tag(name = "학급 참여 response")
public class SchoolJoinRequestDTO {

    //로그인 아이디
    private String id;

    //학급 아이디
    private int classId;

    //학급 비밀번호
    private String schoolPwd;

}
