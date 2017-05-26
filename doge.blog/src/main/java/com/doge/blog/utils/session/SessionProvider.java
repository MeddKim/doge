package com.doge.blog.utils.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;

/**
 * @author: Administrator
 * @date : 2017/5/26 0026
 * @Description:
 */
public interface SessionProvider {
    Serializable getAttribute(HttpServletRequest request, String name);

    void setAttribute(HttpServletRequest request,
                             HttpServletResponse response, String name, Serializable value);

    String getSessionId(HttpServletRequest request) ;

    void logout(HttpServletRequest request, HttpServletResponse response);
}
