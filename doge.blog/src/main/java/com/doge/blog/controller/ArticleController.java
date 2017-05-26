package com.doge.blog.controller;

import com.doge.blog.domain.Content;
import com.doge.blog.domain.User;
import com.doge.blog.service.ArticleService;
import com.doge.blog.service.impl.ArticleServiceImpl;
import com.doge.blog.utils.RuntimeContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author: Administrator
 * @date : 2017/5/26 0026
 * @Description:
 */
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleServiceImpl articleService;

    @Autowired
    HttpServletRequest request;

    @RequestMapping(value = "/contents",method = RequestMethod.GET)
    public List<Content> findContents(){
        System.out.println(Thread.currentThread().getId()+":"+Thread.currentThread().getName());
        System.out.println(RuntimeContext.currentUser());
        List<Content> contents = articleService.findContentPage();
        return contents;
    }

    @RequestMapping(value="/content/{contentId}",method = RequestMethod.GET)
    public Content saveContent(@PathVariable Long contentId){

        if(contentId != null){
            return null;
        }else{
            return articleService.findContentById(contentId);
        }
    }
}
