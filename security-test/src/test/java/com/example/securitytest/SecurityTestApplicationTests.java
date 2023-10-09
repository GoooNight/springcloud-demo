package com.example.securitytest;

import com.example.securitytest.service.SchoolService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class SecurityTestApplicationTests {

    @Autowired
    private SchoolService schoolService;

    @Test
    void contextLoads() {

        String s = "河北省,山西省,辽宁省,吉林省,黑龙江省,江苏省,浙江省,安徽省,福建省,江西省,山东省,河南省,湖北省," +
                "湖南省,广东省,海南省," +
                "四川省,贵州省,云南省,陕西省,甘肃省,青海省,台湾省";
        List<String> provinceList = List.of(s.split(","));


    }

}
