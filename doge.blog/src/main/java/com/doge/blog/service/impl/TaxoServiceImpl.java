package com.doge.blog.service.impl;

import com.doge.blog.domain.Content;
import com.doge.blog.domain.Taxonomy;
import com.doge.blog.mapper.ContentMapper;
import com.doge.blog.mapper.TaxonomyMapper;
import com.doge.blog.service.TaxoService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author: Administrator
 * @date : 2017/6/1 0001
 * @Description:
 */
public class TaxoServiceImpl implements TaxoService{

    @Autowired
    private SqlSession session;

    @Override
    public List<Taxonomy> findTaxos() {
        TaxonomyMapper contentMapper = session.getMapper(TaxonomyMapper.class);
//        List<Taxonomy> contents = contentMapper.selectContentList();
        return null;
    }
}
