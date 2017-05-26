package com.doge.blog.utils.session;

import com.doge.blog.utils.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.Serializable;

/**
 * @author: Administrator
 * @date : 2017/5/26 0026
 * @Description:
 */
@Component
public class HttpSessionProvider implements SessionProvider {

    @Override
    public Serializable getAttribute(HttpServletRequest request, String name) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            return (Serializable) session.getAttribute(name);
        } else {
            return null;
        }
    }

    @Override
    public void setAttribute(HttpServletRequest request,
                             HttpServletResponse response, String name, Serializable value) {
        HttpSession session = request.getSession();
        session.setAttribute(name, value);
    }

    @Override
    public String getSessionId(HttpServletRequest request)  {
        String sid = request.getSession().getId();
        if(request.getSession().getAttribute("sid")!=null){
            System.out.println("sid:"+request.getSession().getAttribute("sid").toString());
            sid = request.getSession().getAttribute("sid").toString();
        }
        if(request.getHeader("sid")!=null){
            String [] headers = request.getHeader("sid").toString().split(";");
            if(headers.length>0){
                for(int i=0;i<headers.length;i++){
                    System.out.println(headers[i]);
                    if(headers[i].trim().startsWith("sid=")){
                        sid = headers[i].trim().substring(4);
                    }
                }
            }
        }
        if(StringUtils.isBlank(sid)){
            System.out.println( "sessionId故障");
        }

        request.getSession().setAttribute("sid", sid);
        return sid;
    }

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            //session失效，退出登陆
            session.invalidate();
        }
    }

}