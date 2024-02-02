package com.ktds.haru.api.school.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SchoolRequestDTO {

    private String schoolName;

    private String schoolGrade;

    private String schoolClass;

    private String schoolPwd;

    private String nickname;

}
