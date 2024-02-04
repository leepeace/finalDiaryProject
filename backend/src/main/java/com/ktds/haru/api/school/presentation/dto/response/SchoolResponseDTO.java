package com.ktds.haru.api.school.presentation.dto.response;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Tag(name = "학급 response")
public class SchoolResponseDTO {

    private int classId;

    private String schoolName;

    private String schoolGrade;

    private String schoolClass;

    private String nickname;
    
}
