package com.example.springsecurityjwt.util;

import com.example.springsecurityjwt.mvc.domain.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Builder;

import java.util.Date;
import java.util.UUID;

/**
 * @author 雨天留恋
 * @date 2023-04-26 15:57
 */
@Builder
public class JWTUtil {

    public static String secret = "luoluo123";

    public String creatToken(User user) {

        return Jwts.builder()
                .claim("userId", user.getId())
                .claim("userName", user.getName())
                .setId(UUID.randomUUID().toString())
                .setExpiration(new Date(System.currentTimeMillis() +  10 * 60 * 1000))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

}
