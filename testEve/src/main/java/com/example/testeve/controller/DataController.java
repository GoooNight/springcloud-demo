package com.example.testeve.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import com.example.testeve.entity.User;
import com.example.testeve.service.UserServiceImpl;
import com.example.testeve.untils.DataSourcesUntil;
import com.example.testeve.view.DataView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 雨天留恋
 */
@Controller
public class DataController {


    @Autowired
    private DataSourcesUntil dataSourcesUntil;
    @Autowired
    private ServletContext context;
    @Autowired
    private UserServiceImpl userService;

    @ResponseBody
    @GetMapping("/getData")
    public void getData(HttpServletRequest request, HttpServletResponse response) throws IOException {
        context.setAttribute("name", "小明");
        System.out.println(context.getAttribute("name"));
        response.setContentType("text/javascript;charset=utf-8");
        response.getWriter().append(JSONObject.toJSONString("你好"));

    }
    @ResponseBody
    @GetMapping("/getData2")
    public JSONPObject getData2()  {
     return dataSourcesUntil.getData();

    }

    @ResponseBody
    @GetMapping("/getData3")
    public DataView<User> getUser() {
        return userService.getUser();
    }

}
