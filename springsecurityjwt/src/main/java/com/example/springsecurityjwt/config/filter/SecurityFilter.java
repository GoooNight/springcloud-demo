package com.example.springsecurityjwt.config.filter;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.springsecurityjwt.mvc.domain.LoginUser;
import com.example.springsecurityjwt.mvc.domain.Permission;
import com.example.springsecurityjwt.mvc.domain.User;
import com.example.springsecurityjwt.mvc.mapper.PermissionMapper;
import com.example.springsecurityjwt.mvc.mapper.UserMapper;
import com.example.springsecurityjwt.util.JWTUtil;
import com.example.springsecurityjwt.util.R;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author 雨天留恋
 * @date 2023-04-26 17:08
 */
@Component
@Slf4j
public class SecurityFilter extends OncePerRequestFilter {

    // 要换成缓存或者redis
    @Autowired
    private UserMapper userMapper;
    // 要换成缓存或者redis
    @Autowired
    private PermissionMapper permissionMapper;


    @Override
    protected void doFilterInternal(HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull FilterChain filterChain) throws ServletException, IOException {
        log.info("-----OncePerRequestFilter-------");
        log.info("-----获取token，没有则return-------");
        String token = request.getHeader("token");
        if (ObjectUtils.isEmpty(token)) {
            filterChain.doFilter(request, response);
            return;
        }
        log.info("-----有token就解析-------");
        log.info("-----解析token-------");
        JwtParser jwtParser = Jwts.parser().setSigningKey(JWTUtil.secret);
        String userId;
        String userName;
        try {
            userId =
                    jwtParser.parseClaimsJws(token).getBody().get("userId").toString();
            userName =
                    jwtParser.parseClaimsJws(token).getBody().get("userName").toString();
        } catch (ExpiredJwtException e){
            log.error("token过期");
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            PrintWriter writer = response.getWriter();
            writer.append(JSON.toJSONString(R.tokenExpired()));
            return;
        }
        catch (Exception e) {
            log.error("token解析失败");
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            PrintWriter writer = response.getWriter();
            writer.append(JSON.toJSONString(R.unauthorized()));
            return;
        }
        User user = userMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getId, userId).eq(User::getName,
                userName));
        if (Optional.ofNullable(user).isEmpty()) {
            log.error("未找到用户");
            filterChain.doFilter(request, response);
            return;
        }
        log.info("-------进入Security-----");
        log.info("-----存入SecurityContextHolder-------");
        List<Permission> permissions = permissionMapper.selectList(new LambdaQueryWrapper<Permission>()
                .eq(Permission::getUid, user.getId()));
        List<String> list =
                permissions.stream().map(Permission::getPermission).map(String::valueOf).collect(Collectors.toList());
        // 第一种写法
        // 构建LoginUser
        // LoginUser loginUser = LoginUser.builder().user(user).build();
        // 获取用户的权限
        // List<SimpleGrantedAuthority> collect =
                // list.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
        // 传入令牌中
        // UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken
        //         = new UsernamePasswordAuthenticationToken(loginUser,null,collect);

        //第二种写法
        // 构建LoginUser
        LoginUser loginUser = LoginUser.builder().user(user).permissions(list).build();
        // 传入令牌中
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken
                = new UsernamePasswordAuthenticationToken(loginUser,null,loginUser.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        log.info("-----放行-------");
        filterChain.doFilter(request, response);
    }
}
