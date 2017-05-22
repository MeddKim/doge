package com.doge.blog.controller;

import com.doge.blog.entity.SysApp;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Administrator
 * @date : 2017/5/22 0022
 * @Description:
 */
@RestController
public class IndexController {

    @RequestMapping("/")
    public String home(){
        SysApp sysApp = SysApp.me.findById(1L);
        String secret = sysApp.getStr("app_secret");
        return secret;
    }
}
