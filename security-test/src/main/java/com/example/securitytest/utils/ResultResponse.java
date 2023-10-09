package com.example.securitytest.utils;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * @author 雨天留恋
 * @date 2023-07-08 10:06
 */
@Getter
public class ResultResponse implements Serializable {

    private Integer code;
    private String message;
    private Object data;


    private ResultResponse(){}

    public static ResultResponse ok(Object o) {
        ResultResponse r =new ResultResponse();
        r.code = HttpStatus.OK.value();
        r.message = HttpStatus.OK.getReasonPhrase();
        r.data = o;
        return r;
    }

    public static ResultResponse badRequest(Object o) {
        ResultResponse r = new ResultResponse();
        r.code = HttpStatus.BAD_REQUEST.value();
        r.message = HttpStatus.BAD_REQUEST.getReasonPhrase();
        r.data = o;
        return r;
    }

}
