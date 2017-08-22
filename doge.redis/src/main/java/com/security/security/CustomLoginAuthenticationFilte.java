package com.security.security;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.security.domain.SysUsers;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.StringUtils;


public class CustomLoginAuthenticationFilte extends UsernamePasswordAuthenticationFilter {

    // 用户的登录信息
    private SysUsers user;

    @Override
    protected String obtainPassword(HttpServletRequest request) {
        System.out.println("MyUsernamePasswordAuthenticationFilter-obtainPassword");
        if (checkJson(request)) {
            if (user != null) {
                return user.getPassword();
            }
        }
        return super.obtainPassword(request);
    }

    @Override
    protected String obtainUsername(HttpServletRequest request) {
        System.out.println("MyUsernamePasswordAuthenticationFilter-obtainUsername");
        if (checkJson(request)) {
            if (user != null) {
                return user.getUsername();
            }
        }
        return super.obtainUsername(request);
    }

    public boolean checkJson(HttpServletRequest request) {
        try {
            if ("application/json".equals(request.getHeader("Content-Type"))) {
                StringBuffer sb = new StringBuffer();
                String line = null;
                BufferedReader reader;
                reader = request.getReader();
                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                }
                if (!StringUtils.isEmpty(sb.toString())) {
                    ObjectMapper mapper = new ObjectMapper();
                    user = mapper.readValue(sb.toString(), SysUsers.class);
                }
                return true;
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;

    }
}

