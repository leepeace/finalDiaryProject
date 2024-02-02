package com.ktds.haru.api.school.service;

import com.ktds.haru.api.school.persistence.repository.SchoolRepository;
import com.ktds.haru.api.school.persistence.repository.SchoolUserRepository;
import com.ktds.haru.api.school.presentation.dto.request.SchoolJoinRequestDTO;
import com.ktds.haru.api.school.presentation.dto.request.SchoolRequestDTO;
import com.ktds.haru.api.school.presentation.dto.request.SchoolUserDTO;
import com.ktds.haru.api.user.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SchoolService {

    private final SchoolRepository schoolRepository;
    private final SchoolUserRepository schoolUserRepository;
    private final UserRepository userRepository;


    public boolean createClass(SchoolRequestDTO schoolRequestDTO, int userId) {
        //학급 school_class 생성
        int resultClass = schoolRepository.createSchoolClass(schoolRequestDTO);

        if (resultClass <= 0) {
            return false;
        }

        //생성한 학급의 pk 얻기
        int schoolId = schoolRepository.getSchoolId();

        String role = "CREATOR";
        int resultSchoolUser = createSchoolUser(userId, schoolId, role);

        if (resultSchoolUser <= 0) {
            return false;
        }

        return true;
    }

    /*
     * school-user 생성
     * */
    public int createSchoolUser(int userId, int schoolId, String roleName) {
        SchoolUserDTO schoolUserDTO = new SchoolUserDTO().setSchoolUser(userId, schoolId, roleName);

        int resultSchoolUser = schoolUserRepository.createSchoolUser(schoolUserDTO);
        return resultSchoolUser;
    }

    /*
    * 학급 참여하기
    * */
    public boolean joinSchoolClass(SchoolJoinRequestDTO dto) {
        //login id로 user pk 얻어오기
        int userId = userRepository.getUserId(dto.getUserId());
        SchoolUserDTO schoolUserDTO = new SchoolUserDTO().setSchoolUser(userId, dto.getSchoolId(), "PARTICIPANT");

        int result = schoolUserRepository.createSchoolUser(schoolUserDTO);
        if(result <= 0){
            return false;
        }

        return true;
    }




}
