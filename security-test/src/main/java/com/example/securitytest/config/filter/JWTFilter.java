package com.example.securitytest.config.filter;


import com.example.securitytest.entity.user.AuthenticationUser;
import com.example.securitytest.entity.user.User;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 雨天留恋
 * @date 2023-07-08 15:57
 */
@Configuration
public class JWTFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        User user = User.builder().id(1).name("小花").build();
        System.out.println("执行");
        List<String> list = new ArrayList<>();
        list.add("ROLE_USER");
        AuthenticationUser authenticationUser = AuthenticationUser.builder().user(user).permissions(list).build();
        SecurityContextHolder.getContext()
                .setAuthentication(new UsernamePasswordAuthenticationToken(authenticationUser, null, authenticationUser.getAuthorities()));
        filterChain.doFilter(request, response);
    }
}
