package com.doge.blog.controller;

import com.doge.blog.domain.Content;
import com.doge.blog.service.impl.ArticleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: Administrator
 * @date : 2017/5/26 0026
 * @Description:
 */
@RestController
public class ArticleController {
    @Autowired
    private ArticleServiceImpl articleService;

    @RequestMapping("/test")
    public String test(){
        List<Content> contents = articleService.findContentPage();
        System.out.println(contents.size());
        return "hello";
    }
}
