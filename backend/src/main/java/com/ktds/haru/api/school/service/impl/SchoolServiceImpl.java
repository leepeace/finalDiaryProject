package com.ktds.haru.api.school.service.impl;

import java.util.List;

import com.ktds.haru.api.school.persistence.repository.SchoolRepository;
import com.ktds.haru.api.school.persistence.repository.SchoolUserRepository;
import com.ktds.haru.api.school.service.SchoolService;
import com.ktds.haru.api.school.presentation.dto.request.SchoolJoinRequestDTO;
import com.ktds.haru.api.school.presentation.dto.request.SchoolRequestDTO;
import com.ktds.haru.api.school.presentation.dto.request.SchoolUserDTO;
import com.ktds.haru.api.school.presentation.dto.response.SchoolResponseDTO;
import com.ktds.haru.api.user.persistence.repository.UserRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SchoolServiceImpl implements SchoolService {

	private final SchoolRepository schoolRepository;
	private final SchoolUserRepository schoolUserRepository;
	private final UserRepository userRepository;

	/*
	 * 학급 모임 만들기
	 * */
	@Override
	public boolean createClass(SchoolRequestDTO schoolRequestDTO, int userId) {
		//학급 school_class 생성
		int resultClass = schoolRepository.createSchoolClass(schoolRequestDTO);

		if (resultClass <= 0) {
			return false;
		}

		//생성한 학급의 pk 얻기
		int schoolId = schoolRepository.getSchoolId();

		String role = "CREATOR";
		int resultSchoolUser = createSchoolUser(userId, schoolId, role);

		return resultSchoolUser > 0;
	}

	/*
	 * school-user 생성
	 * */
	@Override
	public int createSchoolUser(int userId, int schoolId, String roleName) {
		SchoolUserDTO schoolUserDTO = new SchoolUserDTO().setSchoolUser(userId, schoolId, roleName);

		return schoolUserRepository.createSchoolUser(schoolUserDTO);
	}

	/*
	 * 학급 참여하기
	 * */
	@Override
	public boolean joinSchoolClass(SchoolJoinRequestDTO dto) {
		//login id로 user pk 얻어오기
		int userId = getUserId(dto.getId());
		SchoolUserDTO schoolUserDTO = new SchoolUserDTO().setSchoolUser(userId, dto.getClassId(), "PARTICIPANT");

		int result = schoolUserRepository.createSchoolUser(schoolUserDTO);
		return result > 0;
	}

	/*
	 * 학급 비밀번호 일치여부 확인
	 * */
	@Override
	public boolean validatePassword(SchoolJoinRequestDTO schoolJoinRequestDTO) {
		SchoolResponseDTO schoolResponseDTO = schoolRepository.getSchoolPassword(schoolJoinRequestDTO);
		//해당 학급의 학급 비밀번호가 일치하지 않음
		return schoolResponseDTO != null;
	}

	@Override
	public List<SchoolResponseDTO> searchByKeyword(String keyword) {
		return schoolRepository.searchByKeyword(keyword);
	}

	@Override
	public List<SchoolResponseDTO> searchSchoolById(String loginId) {
		//user pk
		int userId = getUserId(loginId);
		return schoolRepository.searchSchoolById(userId);
	}

	/*
	 * 로그인한 사용자의 pk id를 얻어옴
	 * */
	public int getUserId(String loginId) {
		return userRepository.getUserId(loginId);
	}

}
