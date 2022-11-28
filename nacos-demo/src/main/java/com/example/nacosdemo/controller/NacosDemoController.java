package com.example.nacosdemo.controller;

import com.example.nacosdemo.config.NacosConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author 雨天留恋
 */
@RestController
@RefreshScope
public class NacosDemoController {
    @Value("${pattern.dateformat}")
    private String dateformat;

    @Autowired
    private NacosConfig nacosConfig;

    @GetMapping("/getDate")
    public String demo() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(dateformat));
    }
    @GetMapping("/getDate01")
    public String demo01() {
        return nacosConfig.getTest();
    }
}
