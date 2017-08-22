package com.security.security;

import com.google.gson.JsonObject;
import com.security.utils.ResponseJsonUtil;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Meddkim on 2017/8/22.
 */
public class CustomSecurityInterceptor implements Filter {

    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            HttpServletRequest myrequest = (HttpServletRequest) request;
            if (myrequest.getSession().getAttribute("loginUser") == null) {
//                ResponseJsonUtil.jsonResponse(response, "F0001");
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("code",302);
                jsonObject.addProperty("data","登录失败");
                ResponseJsonUtil.jsonResponse(response, jsonObject);
            } else {
                chain.doFilter(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }
    @Override
    public void init(FilterConfig arg0) throws ServletException {

    }
}
