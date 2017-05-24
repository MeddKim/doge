package com.security.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Administrator
 * @date : 2017/5/24 0024
 * @Description:
 */
@Controller
public class HelloController {
    @RequestMapping("/") //index.html
    public String index(){
        System.out.println("index");
        return "index.html";
    }

    @RequestMapping("/hello") //hello.html
    public String hello(){
        System.out.println("hello");
        return "hello.html";
    }

    @RequestMapping("/home") //hello.html
    public String home(){
        System.out.println("home");
        return "home.html";
    }

    @RequestMapping("/login")
    public String login(){
        System.out.println("login");
        return "login.html";
    }

}
