package com.security.utils;

import com.google.gson.JsonElement;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Meddkim on 2017/8/22.
 */
public class ResponseJsonUtil {

    public static void jsonResponse(ServletResponse response, JsonElement json) throws IOException {
        //返回json形式的错误信息
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");

        PrintWriter out = response.getWriter();
        out.write(json.toString());
        out.flush();
        out.close();
        out = null;
    }

}
