package com.doge.blog.service.impl;

import com.doge.blog.domain.Taxonomy;
import com.doge.blog.mapper.TaxonomyMapper;
import com.doge.blog.service.TaxoService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Administrator
 * @date : 2017/6/1 0001
 * @Description:
 */
@Service
public class TaxoServiceImpl implements TaxoService{

    @Autowired
    private SqlSession session;

    @Override
    public List<Taxonomy> findTaxos() {
        TaxonomyMapper taxoMapper = session.getMapper(TaxonomyMapper.class);
        List<Taxonomy> contents = taxoMapper.selectTaxoList();
        return contents;
    }
}
