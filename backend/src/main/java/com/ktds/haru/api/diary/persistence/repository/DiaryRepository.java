package com.ktds.haru.api.diary.persistence.repository;

import java.util.List;
import java.util.Map;

import com.ktds.haru.api.diary.presentation.dto.request.DiaryRequestDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.ktds.haru.api.diary.presentation.dto.response.DiaryResponseDTO;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class DiaryRepository {

    private final SqlSessionTemplate sqlSessionTemplate;


    public List<DiaryResponseDTO> searchDiaryByClassId(int classId) {
        return sqlSessionTemplate.selectList("Diary.searchDiaryByClassId", classId);
    }

    public DiaryResponseDTO searchDetailById(int diaryId) {
        return sqlSessionTemplate.selectOne("Diary.searchDetailById", diaryId);
    }

    public int deleteById(Map<String, Object> params) {
        return sqlSessionTemplate.delete("Diary.deleteById", params);
    }

    public int createDiary(Map<String, Object> request) {
        return sqlSessionTemplate.insert("Diary.createDiary", request);
    }

}
