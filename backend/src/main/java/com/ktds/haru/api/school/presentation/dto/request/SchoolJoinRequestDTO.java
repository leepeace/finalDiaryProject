package com.ktds.haru.api.school.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SchoolJoinRequestDTO {

    private String userId;

    private int schoolId;

    private String schoolPwd;

}
