package com.doge.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: Administrator
 * @date : 2017/5/22 0022
 * @Description:
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(){
        return "/blog/index.html";
    }

}
