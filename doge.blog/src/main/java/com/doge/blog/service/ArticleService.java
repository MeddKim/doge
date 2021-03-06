package com.doge.blog.service;

import com.doge.blog.domain.Content;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Administrator
 * @date : 2017/5/25 0025
 * @Description:
 */
public interface ArticleService {

    //查询文章列表
    List<Content> findContentPage();

    //保存文章
    Boolean saveContent(Content content);

    Content findContentById(Long id);
}
