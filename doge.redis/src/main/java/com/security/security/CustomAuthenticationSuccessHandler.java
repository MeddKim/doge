package com.security.security;

import com.google.gson.JsonObject;
import com.security.utils.ResponseJsonUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Meddkim on 2017/8/22.
 */
public class CustomAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler{

    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth)
            throws IOException, ServletException {
        if ("application/json".equals(request.getHeader("Content-Type"))) {

            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("code",200);
            jsonObject.addProperty("data","登录成功！！！！");

            ResponseJsonUtil.jsonResponse(response,jsonObject);
        } else {
            super.onAuthenticationSuccess(request, response, auth);
        }
    }
}
