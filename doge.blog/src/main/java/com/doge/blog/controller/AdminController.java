package com.doge.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: Administrator
 * @date : 2017/5/23 0023
 * @Description:
 */
@Controller
public class AdminController {

    @RequestMapping("/admin")
    public String admin(){
        return "admin/dist/index.html";
    }
}
