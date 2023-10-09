package com.example.securitytest.config.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;

import java.io.IOException;

/**
 * @author 雨天留恋
 * @date 2023-07-08 15:17
 *  由于使用的security，因此跨域请求应该配置在mvc之前，因此此配置无法适用
 */
// @Configuration
public class CorsFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN,"*");
        response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS,"GET, POST, DELETE, PUT");
        response.setHeader(HttpHeaders.ACCESS_CONTROL_MAX_AGE,"3600");
        response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS,"*");
        // response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_CREDENTIALS,"true");
        if (request.getMethod().equals(HttpMethod.OPTIONS.name())) {
            response.setStatus(HttpStatus.OK.value());
            return;
        }
        System.out.println("===1我先===");
        filterChain.doFilter(servletRequest, servletResponse);

    }
}
