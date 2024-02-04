package com.ktds.haru.api.diary.presentation.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ktds.haru.api.common.BaseResponse;
import com.ktds.haru.api.diary.presentation.dto.response.DiaryResponseDTO;
import com.ktds.haru.api.diary.service.DiaryService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@RequestMapping("/diary")
@Tag(name = "diary controller")
@Slf4j
public class DiaryController {

	private final DiaryService diaryService;

	//일기장 등록

	//일기장 삭제

	//일기장 수정

	//일기장 상세 조회
	@GetMapping("/detail")
	public BaseResponse<?> searchDetailById(@RequestParam int diaryId) {
		DiaryResponseDTO response = diaryService.searchDetailById(diaryId);

		if (response == null) {
			return new BaseResponse<>(null, HttpStatus.INTERNAL_SERVER_ERROR.value(), "일기장 조회 실패");
		}

		return new BaseResponse<>(response, HttpStatus.OK.value(), "일기장 조회 성공");
	}

	//학급 일기장 전체 조회
	@GetMapping("")
	@Operation(summary = "참여한 학급의 일기장 전체 조회", description = "내가 참여한 학급의 모든 일기장 전체 조회 기능")
	public BaseResponse<?> searchSchoolDiary(@RequestParam int classId) {
		List<DiaryResponseDTO> responses = diaryService.searchDiaryByClassId(classId);
		if (responses.isEmpty()) {
			return new BaseResponse<>(null, HttpStatus.NO_CONTENT.value(), "학급 일기장이 없습니다.");
		}

		return new BaseResponse<>(responses, HttpStatus.OK.value(), "학급 일기장 조회 성공");
	}

}
