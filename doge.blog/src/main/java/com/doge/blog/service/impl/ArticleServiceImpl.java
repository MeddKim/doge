package com.doge.blog.service.impl;

import com.doge.blog.domain.Content;
import com.doge.blog.mapper.ContentMapper;
import com.doge.blog.service.ArticleService;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Administrator
 * @date : 2017/5/26 0026
 * @Description:
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private SqlSession session;

    @Override
    public List<Content> findContentPage() {
        ContentMapper contentMapper = session.getMapper(ContentMapper.class);
        List<Content> contents = contentMapper.selectContentList();
        return contents;
    }

    @Override
    public Boolean saveContent(Content content) {
        return null;
    }

    @Override
    public Content findContentById(Long id) {
        ContentMapper contentMapper = session.getMapper(ContentMapper.class);
        Content content = contentMapper.selectByPrimaryKey(id);
        return content;
    }
}
