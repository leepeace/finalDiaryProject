package com.ktds.haru.api.school.presentation.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class SchoolUserDTO {

    private int classId;
    private int userId;
    private String role;

    @Builder
    public SchoolUserDTO(int classId, int userId, String role) {
        this.classId = classId;
        this.userId = userId;
        this.role = role;
    }


    public SchoolUserDTO setSchoolUser(int userId, int schoolId, String roleName) {
        return SchoolUserDTO.builder()
                .userId(userId)
                .role(roleName)
                .classId(schoolId)
                .build();
    }
}
