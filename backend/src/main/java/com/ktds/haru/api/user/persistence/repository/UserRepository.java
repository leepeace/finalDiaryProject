package com.ktds.haru.api.user.persistence.repository;

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

}
