package com.ktds.haru.api.school.presentation.controller;

import java.util.List;

import com.ktds.haru.api.school.service.impl.SchoolServiceImpl;
import com.ktds.haru.api.user.service.impl.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ktds.haru.api.common.BaseResponse;
import com.ktds.haru.api.school.presentation.dto.request.SchoolJoinRequestDTO;
import com.ktds.haru.api.school.presentation.dto.request.SchoolRequestDTO;
import com.ktds.haru.api.school.presentation.dto.response.SchoolResponseDTO;
import com.ktds.haru.api.school.presentation.validator.SchoolValidator;
import com.ktds.haru.api.user.presentation.validator.UserValidator;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@RequestMapping("/school")
@Tag(name = "school controller")
@Slf4j
public class SchoolController {

	private final SchoolServiceImpl schoolService;
	private final SchoolValidator schoolValidator;
	private final UserServiceImpl userServiceImpl;

	private final UserValidator userValidator;

	/*
	 * 학급 만들기
	 * */
	@PostMapping("/create")
	@Operation(summary = "학급 만들기", description = "사용자는 정보를 입력하여 학급을 만들 수 있다.")
	public BaseResponse<?> createClass(@RequestBody SchoolRequestDTO schoolRequestDTO, @RequestParam String id) {
		//NULL 검증
		schoolValidator.validateSchoolRequestDTO(schoolRequestDTO);

		int userId = userServiceImpl.getUserIdById(id);//로그인 아이디로 pk id를 얻어옴

		boolean result = schoolService.createClass(schoolRequestDTO, userId);
		if (!result) {
			return new BaseResponse<>(false, HttpStatus.INTERNAL_SERVER_ERROR.value(), "학급 만들기 실패");
		}

		return new BaseResponse<>(true, HttpStatus.OK.value(), "학급 만들기 성공");
	}

	/*
	 * 학급 모임 참여하기
	 * */
	@PostMapping("/join")
	@Operation(summary = "학급 참여하기", description = "사용자는 자신이 원하는 학급에 참여할 수 있다.")
	public BaseResponse<?> joinClass(@RequestBody SchoolJoinRequestDTO schoolJoinRequestDTO) {

		//NULL 체크
		schoolValidator.validateSchoolJoinRequestDTO(schoolJoinRequestDTO);

		//학급 패스워드가 일치하는지 확인함
		boolean checkResult = schoolService.validatePassword(schoolJoinRequestDTO);

		//학급 패스원드가 틀린 경우
		if (!checkResult) {
			return new BaseResponse<>(false, HttpStatus.UNPROCESSABLE_ENTITY.value(), "학급 패스워드가 틀렸습니다.");
		}

		boolean result = schoolService.joinSchoolClass(schoolJoinRequestDTO);

		//학급 참여하기에 실패한 경우
		if (!result) {
			return new BaseResponse<>(false, HttpStatus.INTERNAL_SERVER_ERROR.value(), "학급 참여에 실패함");
		}

		return new BaseResponse<>(true, HttpStatus.OK.value(), "학급 참여하기 성공");
	}

	/*
	 * 학급 검색하기
	 * */
	@GetMapping("/search")
	@Operation(summary = "학급 검색하기", description = "사용자는 자신이 원하는 학급의 닉네임을 검색할 수 있다.")
	public BaseResponse<?> searchSchoolClass(@RequestParam String keyword) {
		List<SchoolResponseDTO> response = schoolService.searchByKeyword(keyword);
		if (response == null) {
			return new BaseResponse<>(null, HttpStatus.NO_CONTENT.value(), "학급 검색하기 조회 결과 없음");
		}

		return new BaseResponse<>(response, HttpStatus.OK.value(), "학급 검색하기 성공");
	}

	/*
	 * 사용자가 참여중인 학급 조회하기
	 * */
	@GetMapping
	@Operation(summary = "나의 학급 조회하기", description = "사용자는 자신이 참여한 학급을 검색할 수 있다.")
	public BaseResponse<?> searchSchoolById(@RequestParam String id) {
		//null check
		userValidator.validateLoginId(id);

		List<SchoolResponseDTO> responses = schoolService.searchSchoolById(id);

		if (responses.isEmpty()) {
			return new BaseResponse<>(null, HttpStatus.NO_CONTENT.value(), "나의 학급 정보가 없습니다.");
		}

		return new BaseResponse<>(responses, HttpStatus.OK.value(), "나의 학급 조회 성공");
	}

}
