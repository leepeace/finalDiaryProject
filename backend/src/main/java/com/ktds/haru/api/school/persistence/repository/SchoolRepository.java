package com.ktds.haru.api.school.persistence.repository;

import java.util.List;

import com.ktds.haru.api.school.presentation.dto.request.SchoolJoinRequestDTO;
import com.ktds.haru.api.school.presentation.dto.request.SchoolRequestDTO;
import com.ktds.haru.api.school.presentation.dto.response.SchoolResponseDTO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class SchoolRepository {

    private final SqlSessionTemplate sqlSessionTemplate;

    public int createSchoolClass(SchoolRequestDTO schoolRequestDTO) {
        return sqlSessionTemplate.insert("School.createClass", schoolRequestDTO);
    }

    public int getSchoolId(){
        return sqlSessionTemplate.selectOne("School.getCurrentId");
    }

    /*
    * 비밀번호 일치여부 확인
    * */
    public SchoolResponseDTO getSchoolPassword(SchoolJoinRequestDTO schoolJoinRequestDTO){
        return sqlSessionTemplate.selectOne("School.checkPwd", schoolJoinRequestDTO);
    }


    /*
    * 키워드로 검색
    * */
    public List<SchoolResponseDTO> searchByKeyword(String keyword){
        return sqlSessionTemplate.selectList("School.searchByKeyword", keyword);
    }
}
