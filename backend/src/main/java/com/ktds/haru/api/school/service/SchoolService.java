package com.ktds.haru.api.school.service;

import com.ktds.haru.api.school.presentation.dto.request.SchoolJoinRequestDTO;
import com.ktds.haru.api.school.presentation.dto.request.SchoolRequestDTO;
import com.ktds.haru.api.school.presentation.dto.response.SchoolResponseDTO;

import java.util.List;

public interface SchoolService {
    /*
     * 학급 모임 만들기
     * */
    boolean createClass(SchoolRequestDTO schoolRequestDTO, int userId);

    /*
     * school-user 생성
     * */
    int createSchoolUser(int userId, int schoolId, String roleName);

    /*
     * 학급 참여하기
     * */
    boolean joinSchoolClass(SchoolJoinRequestDTO dto);

    /*
     * 학급 비밀번호 일치여부 확인
     * */
    boolean validatePassword(SchoolJoinRequestDTO schoolJoinRequestDTO);

    List<SchoolResponseDTO> searchByKeyword(String keyword);

    List<SchoolResponseDTO> searchSchoolById(String loginId);
}
