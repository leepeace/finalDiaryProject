package com.ktds.haru.api.user.persistence.repository;

import com.ktds.haru.api.user.presentation.dto.request.LoginRequestDTO;
import com.ktds.haru.api.user.presentation.dto.request.UserRequestDTO;
import com.ktds.haru.api.user.presentation.dto.response.UserResponseDTO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final SqlSessionTemplate sqlSessionTemplate;


    /*
    * 아이디 중복체크
    * */
    public String checkValidateId(String id){
        return sqlSessionTemplate.selectOne("User.checkId", id);
    }

    public UserResponseDTO login(LoginRequestDTO loginRequestDTO) {
        return sqlSessionTemplate.selectOne("User.login", loginRequestDTO);
    }

    public int signUp(UserRequestDTO user) {
        return sqlSessionTemplate.insert("User.signUp", user);
    }
}
