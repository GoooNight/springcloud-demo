package com.example.springsecurityjwt.config.exception;

import com.example.springsecurityjwt.util.R;
import lombok.extern.slf4j.Slf4j;
import net.sf.jsqlparser.util.validation.ValidationException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Objects;

import static com.example.springsecurityjwt.config.constant.Constant.PACKAGE_NAME;

/**
 * 全局异常统一处理
 *
 * @author Gooonight
 * @since 2023-04-10 19:34:54
 */
@Slf4j
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
    /**
     * 校验传参
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {BindException.class, ValidationException.class, MethodArgumentNotValidException.class})
    public R handleBadRequest(Exception e) {
        if (e instanceof BindException) {
            return R.badRequest().data(Objects.requireNonNull(((BindException) e).getFieldError()).getDefaultMessage());
        } else {
            return R.badRequest().data(e(e));
        }
    }

    /**
     * 全局异常处理
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public R exception(Exception e) {
        return R.exp().data(e(e));
    }
    /**
     * 404异常处理
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public R notFound(Exception e) {
        return R.notFound().data(e(e));
    }

    /**
     * 异常信息处理主体方法
     *
     * @param e 异常对象
     * @return 异常解析信息
     */
    private String e(Exception e) {
        ByteArrayOutputStream printStackTrace = new ByteArrayOutputStream();
        e.printStackTrace(new PrintStream(printStackTrace));
        log.error(String.valueOf(printStackTrace));
        //错误信息
        StringBuilder errorMessage = new StringBuilder();
        errorMessage.append(e);
        if (StringUtils.isBlank(e.getMessage())) {
            //处理
            log.error(String.valueOf(errorMessage));
            return String.valueOf(errorMessage);
        }
        StackTraceElement[] stackTrace = e.getStackTrace();
        for (StackTraceElement stackTraceElement : stackTrace) {
            String className = stackTraceElement.getClassName();
            if (className.startsWith(PACKAGE_NAME)) {
                String errorName = ";" + stackTraceElement.getClassName();
                errorMessage.append(errorName);
                String errorLineNumber = ":" + stackTraceElement.getLineNumber();
                errorMessage.append(errorLineNumber);
                //处理
                log.error(String.valueOf(errorMessage));
                return String.valueOf(errorMessage);
            }
        }
        //处理
        log.error(String.valueOf(errorMessage));
        return String.valueOf(errorMessage);
    }
}
