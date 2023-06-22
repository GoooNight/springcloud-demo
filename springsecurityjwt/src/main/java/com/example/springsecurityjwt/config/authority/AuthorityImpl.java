package com.example.springsecurityjwt.config.authority;

import com.example.springsecurityjwt.mvc.domain.LoginUser;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 雨天留恋
 * @date 2023-05-10 10:33
 */
@Component("ex")
public class AuthorityImpl {

    public boolean hasAuthority(String str) {
        String[] roles = str.split(":");
        LoginUser loginUser = (LoginUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<String> permissions = loginUser.getPermissions();
        for (String role : roles) {
            if (!permissions.contains(role)) {
                return false;
            }
        }
        return true;
    }

}
