package com.ktds.haru.api.diary.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DiaryRequestDTO {
    private int diaryId;

    private String title;

    private String content;

    private int classId;

    private String id;
}
