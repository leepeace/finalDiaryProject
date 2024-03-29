package com.ktds.haru.api.diary.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ktds.haru.api.diary.presentation.dto.request.DiaryRequestDTO;
import com.ktds.haru.api.diary.presentation.dto.request.DiaryUpdateRequestDTO;
import com.ktds.haru.api.user.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.ktds.haru.api.diary.persistence.repository.DiaryRepository;
import com.ktds.haru.api.diary.presentation.dto.response.DiaryResponseDTO;

@Service
@RequiredArgsConstructor
@Slf4j
public class DiaryService {

    private final DiaryRepository diaryRepository;
    private final UserRepository userRepository;

    public List<DiaryResponseDTO> searchDiaryByClassId(int classId) {
        return diaryRepository.searchDiaryByClassId(classId);
    }

    public DiaryResponseDTO searchDetailById(int diaryId) {
        return diaryRepository.searchDetailById(diaryId);
    }

    public boolean deleteById(int diaryId, String loginId) {
        Integer userId = getUserId(loginId);
        if(userId == null){
            return false;
        }

        Map<String, Object> params = new HashMap<>();
        params.put("userId", userId);
        params.put("diaryId", diaryId);

        int result = diaryRepository.deleteById(params);

        //삭제 성공이면 1, 실패이면 0 반환
        return result > 0;
    }


    public boolean createDiary(DiaryRequestDTO request){
        Integer userId = getUserId(request.getId());
        if(userId == null){
            return false;
        }

        Map<String, Object> params = new HashMap<>();
        params.put("userId", userId);
        params.put("title", request.getTitle());
        params.put("content", request.getContent());
        params.put("classId", request.getClassId());

        int result = diaryRepository.createDiary(params);

        //삭제 성공이면 1, 실패이면 0 반환
        return result > 0;
    }


    /*
     * 로그인한 사용자의 pk id를 얻어옴
     * */
    public Integer getUserId(String loginId) {
        Integer response = userRepository.getUserId(loginId);
        if (response == null) {
            throw new NullPointerException("User ID not found for login ID: " + loginId);
        }
        return response;
    }


    public boolean updateDiaryInfo(DiaryUpdateRequestDTO request) {
        Integer userId = getUserId(request.getId());
        if(userId == null){
            return false;
        }

        Map<String, Object> params = new HashMap<>();
        params.put("userId", userId);
        params.put("title", request.getTitle());
        params.put("content", request.getContent());
        params.put("diaryId", request.getDiaryId());

        int response = diaryRepository.updateDiaryInfo(params);

        return response > 0;
    }
}
