package com.ktds.haru.api.diary.presentation.controller;

import java.util.List;

import com.ktds.haru.api.diary.presentation.dto.request.DiaryUpdateRequestDTO;
import com.ktds.haru.api.diary.presentation.validator.DiaryValidator;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.ktds.haru.api.common.BaseResponse;
import com.ktds.haru.api.diary.presentation.dto.request.DiaryRequestDTO;
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
    private final DiaryValidator diaryValidator;

    //일기장 등록
    @PostMapping("")
    @Operation(summary = "일기장 등록", description = "자신의 일기장을 등록할 수 있다.")
    public BaseResponse<?> createDiary(@RequestBody DiaryRequestDTO diaryRequestDTO) {

        boolean response = diaryService.createDiary(diaryRequestDTO);
        if (response) {
            return new BaseResponse<>(response, HttpStatus.OK.value(), "일기장 등록 성공");
        }
        return new BaseResponse<>(response, HttpStatus.INTERNAL_SERVER_ERROR.value(), "일기장 등록 실패");
    }

    //일기장 삭제
    @DeleteMapping
    @Operation(summary = "일기장 삭제", description = "자신의 일기장을 삭제할 수 있다.")
    public BaseResponse<?> deleteDiary(@Parameter(name = "id", description = "사용자의 아이디", required = true, example = "user123") @RequestParam(name = "id") String id,
                                       @Parameter(name = "diaryId", description = "다이어리의 pk", required = true, example = "1") @RequestParam(name = "diaryId") int diaryId) {

        boolean response = diaryService.deleteById(diaryId, id);
        if (response) {
            return new BaseResponse<>(response, HttpStatus.OK.value(), "일기장 삭제 성공");
        }

        return new BaseResponse<>(response, HttpStatus.INTERNAL_SERVER_ERROR.value(), "일기장 삭제 실패");
    }

    //일기장 수정
    @PutMapping
    @Operation(summary = "일기장 수정", description = "자신의 일기장을 수정할 수 있다.")
    public BaseResponse<?> updateDiary(@RequestBody DiaryUpdateRequestDTO diaryUpdateRequestDTO) {
        //null check
        diaryValidator.validateDiaryUpdateRequestDTO(diaryUpdateRequestDTO);

        boolean response = diaryService.updateDiaryInfo(diaryUpdateRequestDTO);
        if (response) {
            return new BaseResponse<>(response, HttpStatus.OK.value(), "일기장 수정 성공");
        }


        return new BaseResponse<>(response, HttpStatus.INTERNAL_SERVER_ERROR.value(), "일기장 수정 실패");
    }

    //일기장 상세 조회
    @GetMapping("/detail")
    @Operation(summary = "일기장 상세 조회", description = "일기장을 상세조회한다.")
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
