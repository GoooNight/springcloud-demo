package com.example.securitytest.controller;

import com.example.securitytest.entity.school.School;
import com.example.securitytest.service.SchoolService;
import com.example.securitytest.utils.ResultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 雨天留恋
 * @date 2023-07-31 9:54
 */

@RestController()
@RequestMapping("school")
public class SchoolController {

    @Autowired
    private SchoolService schoolService;


    @PostMapping("/add")
    public ResultResponse addSchool(@RequestBody School school) {

        return schoolService.save(school)? ResultResponse.ok("插入成功"):ResultResponse.badRequest("插入失败");

    }

}
