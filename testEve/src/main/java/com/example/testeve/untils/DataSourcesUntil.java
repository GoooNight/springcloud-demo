package com.example.testeve.untils;


import com.alibaba.fastjson.JSONPObject;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;


/**
 * @author 雨天留恋
 */
@Component
public class DataSourcesUntil {

    public JSONPObject getData(){
        String url = "https://interface.sina.cn/news/wap/fymap2020_data.d.json";
        HttpMethod method = HttpMethod.GET;
        LinkedMultiValueMap params = new LinkedMultiValueMap();
        // TODO Auto-generated method stub
        RestTemplate template = new RestTemplate();
        ResponseEntity<JSONPObject> response = template.getForEntity(url, JSONPObject.class);


        System.out.println(url);
        System.out.println(response.getBody());
        return response.getBody();
    }

}
