package com.ktds.haru.api.school.presentation.controller;

import com.ktds.haru.api.common.BaseResponse;
import com.ktds.haru.api.school.service.SchoolService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/school")
@Tag(name = "school controller")
@Slf4j
public class SchoolController {

    private final SchoolService schoolService;


    /*
    * 학급 만들기
    * */
    @PostMapping
    public BaseResponse<?> createClass(){
        return null;
    }


}
