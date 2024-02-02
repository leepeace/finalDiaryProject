package com.ktds.haru.api.school.persistence.repository;

import com.ktds.haru.api.school.presentation.dto.request.SchoolRequestDTO;
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
}
