package com.ktds.haru.api.diary.presentation.dto.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DiaryResponseDTO {

	private int diaryId;
	private String title;
	private String content;
	private LocalDateTime regDate;
	private String id;
	private String nickname;

	
}
