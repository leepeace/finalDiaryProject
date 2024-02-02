package com.ktds.haru.api.school.persistence.repository;

import com.ktds.haru.api.school.presentation.dto.request.SchoolUserDTO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class SchoolUserRepository {


    private final SqlSessionTemplate sqlSessionTemplate;


    public int createSchoolUser(SchoolUserDTO dto) {
        return sqlSessionTemplate.insert("SchoolUser.createSchoolUser", dto);
    }

}
