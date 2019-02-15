package com.hlc.apespace.user.filter;

import com.hlc.apespace.common.util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
    *@ClassName JwtFilter
    *@Description todo
    *@Author Liang
    *@Date 2019/2/14 13:45
    *@Version 1.0
**/
@Component
public class JwtFilter extends HandlerInterceptorAdapter {

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("通过拦截器");
        String authorite = request.getHeader("Authorization");
        if (StringUtils.isNotEmpty(authorite) && authorite.startsWith("Bearer ")) {
            String token = authorite.substring(7);
            Claims claims = jwtUtil.parseJwtStr(token);
            if (claims != null) {
                if ("admin".equals(claims.get("roles"))) {
                    request.setAttribute("admin_claims", claims);
                }
                if ("user".equals(claims.get("roles"))) {
                    request.setAttribute("user_claims", claims);
                }
            }
        }
        return true;
    }



}
