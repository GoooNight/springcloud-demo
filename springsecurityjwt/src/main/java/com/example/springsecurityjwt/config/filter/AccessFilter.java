package com.example.springsecurityjwt.config.filter;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Stream;

/**
 * 提供跨域支持
 *
 * @author Gooonight
 * @since 2023-04-10 19:34:54
 * TODO 加了@WebFilter要配合@ServletComponentScan使用，如果单独使用@Configuration,则默认全部路劲生效
 */
@Slf4j
// @WebFilter(urlPatterns = "/user")
@Configuration
public class AccessFilter implements Filter {
    /**
     * 跨域允许的方法
     */
    private static String METHODS = "";

    //使用Stream流将HttpMethod中的方法常量赋予METHODS
    static {
        Stream.of(HttpMethod.values()).forEach(o -> {
            if (StringUtils.isBlank(METHODS)) {
                METHODS = String.valueOf(o);
            } else {
                METHODS += ", " + o;
            }
        });
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("-----------------跨域过滤器初始化-------------------");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException,
            ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "*");
        response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, METHODS);
        response.setHeader(HttpHeaders.ACCESS_CONTROL_MAX_AGE, "3600");
        response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS, "*");
        //跨域时会首先发送一个option请求，这里我们给option请求直接返回正常状态
        if (request.getMethod().equals(HttpMethod.OPTIONS.name())) {
            response.setStatus(HttpStatus.OK.value());
            return;
        }
        log.info("-----------------执行跨域过滤器-------------------");
        chain.doFilter(req, res);
    }

    @Override
    public void destroy() {
        log.info("-----------------跨域过滤器销毁-------------------");
    }
}

