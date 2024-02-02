package com.ktds.haru.api.diary.persistence.repository;

import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class DiaryRepository {

    private final SqlSessionTemplate sqlSessionTemplate;



}
