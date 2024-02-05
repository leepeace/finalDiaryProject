package com.ktds.haru.api.diary.presentation.validator;

import com.ktds.haru.api.common.CommonValidator;
import com.ktds.haru.api.diary.presentation.dto.request.DiaryRequestDTO;
import com.ktds.haru.api.diary.presentation.dto.request.DiaryUpdateRequestDTO;
import org.springframework.stereotype.Component;

@Component
public class DiaryValidator extends CommonValidator {

    public void validateDiaryRequestDTO(DiaryRequestDTO request) {
        checkStringType(request.getTitle(), "제목");
        checkStringType(request.getContent(), "내용");
        checkIntType(request.getDiaryId(), "다이어리 아이디");
        checkIntType(request.getClassId(), "학급 아이디");
        checkStringType(request.getId(), "사용자 아이디");
    }


    public void validateDiaryUpdateRequestDTO(DiaryUpdateRequestDTO request) {
        checkStringType(request.getTitle(), "제목");
        checkStringType(request.getContent(), "내용");
        checkIntType(request.getDiaryId(), "다이어리 아이디");
        checkStringType(request.getId(), "사용자 아이디");
    }

}
