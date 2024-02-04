package com.ktds.haru.api.diary.service;

import java.util.List;

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


	public List<DiaryResponseDTO> searchDiaryByClassId(int classId){
		return diaryRepository.searchDiaryByClassId(classId);
	}

}
