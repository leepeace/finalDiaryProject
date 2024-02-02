package com.ktds.haru.api.school.presentation.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class SchoolUserDTO {

    private int class_id;
    private int user_id;
    private String role;

    @Builder
    public SchoolUserDTO(int class_id, int user_id, String role) {
        this.class_id = class_id;
        this.user_id = user_id;
        this.role = role;
    }


    public SchoolUserDTO setSchoolUser(int userId, int schoolId, String roleName) {
        return SchoolUserDTO.builder()
                .user_id(userId)
                .role(roleName)
                .class_id(schoolId)
                .build();
    }
}
