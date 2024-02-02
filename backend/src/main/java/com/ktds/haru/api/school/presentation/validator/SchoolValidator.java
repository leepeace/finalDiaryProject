package com.ktds.haru.api.school.presentation.validator;

import com.ktds.haru.api.common.CommonValidator;
import com.ktds.haru.api.school.presentation.dto.request.SchoolRequestDTO;
import org.springframework.stereotype.Component;

@Component
public class SchoolValidator extends CommonValidator {

    public void validateSchoolRequestDTO(SchoolRequestDTO school){
        checkStringType(school.getSchoolClass(), "학급 학년");
        checkStringType(school.getSchoolName(), "학교 이름");
        checkStringType(school.getSchoolPwd(), "학급 비밀번호");
        checkStringType(school.getNickname(), "학급 닉네임");
        checkStringType(school.getSchoolGrade(), "학급 반");
    }

}
