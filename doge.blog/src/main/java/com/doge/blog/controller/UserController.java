package com.doge.blog.controller;

import com.doge.blog.config.DogeConst;
import com.doge.blog.domain.User;
import com.doge.blog.utils.RuntimeContext;
import com.doge.blog.utils.session.SessionProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author: Administrator
 * @date : 2017/5/26 0026
 * @Description:
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private SessionProvider sessionProvider;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public boolean login(){
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        HttpSession session = request.getSession();
        session.setAttribute(DogeConst.LOGIN_SESSION_KEY,user);

        return true;
    }

}
