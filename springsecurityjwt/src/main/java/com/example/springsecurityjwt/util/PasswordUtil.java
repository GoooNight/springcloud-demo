package com.example.springsecurityjwt.util;

import com.example.springsecurityjwt.mvc.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author 雨天留恋
 * @date 2023-04-27 14:03
 */
@Component
public class PasswordUtil {

    private PasswordEncoder passwordEncoder;

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public boolean passwordMatches(String password, String encodePassword) {
        return passwordEncoder.matches(password, encodePassword);
    }

    public User passwordEncode(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return user;
    }
}
