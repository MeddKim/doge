package com.doge.blog.controller;

import com.doge.blog.domain.Content;
import com.doge.blog.domain.User;
import com.doge.blog.service.impl.ArticleServiceImpl;
import com.doge.blog.utils.ResultMapUtils;
import com.doge.blog.utils.RuntimeContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public Map findContents(){
        List<Content> contents = articleService.findContentPage();

        return ResultMapUtils.successResult(contents);
    }

    @RequestMapping(value="/content/{contentId}",method = RequestMethod.GET)
    public Content findContent(@PathVariable Long contentId){

        if(contentId == null){
            return null;
        }else{
            return articleService.findContentById(contentId);
        }
    }

    @RequestMapping(value = "/content",method = RequestMethod.POST)
    public boolean saveContent(){
        return false;
    }

    @RequestMapping(value="/test")
    public Map<String,Object> test(){
        Map map = new HashMap();
        map.put("code",200);
        User user = new User();
        user.setUsername("张三");
        user.setPassword("李四");
        List<User> list = new ArrayList<User>();
        list.add(user);
        list.add(user);
        map.put("data",list);
        return map;
    }
}
