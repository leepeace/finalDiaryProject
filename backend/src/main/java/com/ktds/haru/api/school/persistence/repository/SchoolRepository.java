package com.ktds.haru.api.school.persistence.repository;

import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class SchoolRepository {

    private final SqlSessionTemplate sqlSessionTemplate;
    
}
