package com.doge.blog.controller;

import com.doge.blog.domain.User;
import com.doge.blog.utils.RuntimeContext;
import com.doge.blog.utils.session.SessionProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

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

    @RequestMapping(value = "/login/{name}/{password}",method = RequestMethod.GET)
    public boolean login(@PathVariable String name,@PathVariable String password){
        User user = new User();
        user.setUsername("张三");
        user.setPassword("12345566");
        System.out.println(Thread.currentThread().getId()+":"+Thread.currentThread().getName());
        RuntimeContext.currentUser(user);
        return true;
    }
}
