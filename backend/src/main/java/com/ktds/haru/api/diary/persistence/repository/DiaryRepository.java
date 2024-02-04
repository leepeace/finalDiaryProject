package com.ktds.haru.api.diary.persistence.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.ktds.haru.api.diary.presentation.dto.response.DiaryResponseDTO;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class DiaryRepository {

    private final SqlSessionTemplate sqlSessionTemplate;


    public List<DiaryResponseDTO> searchDiaryByClassId(int classId){
        return sqlSessionTemplate.selectList("Diary.searchDiaryByClassId", classId);
    }

    public DiaryResponseDTO searchDetailById(int diaryId){
        return sqlSessionTemplate.selectOne("Diary.searchDetailById", diaryId);
    }

}
