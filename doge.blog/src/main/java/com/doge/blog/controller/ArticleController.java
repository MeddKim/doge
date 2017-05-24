package com.doge.blog.controller;

import com.doge.blog.entity.Content;
import com.jfinal.kit.JsonKit;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: Administrator
 * @date : 2017/5/24 0024
 * @Description:
 */
@RestController
@RequestMapping("/article")
public class ArticleController {

    @RequestMapping(value = "/content/list",method = RequestMethod.GET)
    public String findArticle(){
        List<Content> contents = Content.me.findContents();

        return JsonKit.toJson(contents,2);
    }

}
