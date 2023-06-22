package com.example.spring3test.exception;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Objects;

/**
 * @author 雨天留恋
 * @date 2023-06-22 11:03
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String exceptionHandle(MethodArgumentNotValidException e) {
        return Objects.requireNonNull(e.getFieldError()).getDefaultMessage();
    }
}
