package com.ktds.haru.api.school.presentation.dto.request;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Tag(name = "학급 모임 만들기 request")
public class SchoolRequestDTO {

    private String schoolName;

    private String schoolGrade;

    private String schoolClass;

    private String schoolPwd;

    private String nickname;

}
