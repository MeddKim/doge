package com.doge.blog.service.impl;

import com.doge.blog.domain.Content;
import com.doge.blog.domain.dto.MappingDetailDto;
import com.doge.blog.mapper.ContentMapper;
import com.doge.blog.mapper.MappingMapper;
import com.doge.blog.service.ArticleService;
import com.doge.blog.utils.PaginationUtils;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author: Administrator
 * @date : 2017/5/26 0026
 * @Description:
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ContentMapper contentMapper;
    @Autowired
    private MappingMapper mappingMapper;

    @Override
    public List<Content> findContentPage() {
        List<Content> contents = contentMapper.selectContentList();
        return contents;
    }

    @Override
    public Boolean saveContent(Content content) {
        return null;
    }

    @Override
    public Content findContentById(Long id) {
        Content content = contentMapper.selectByPrimaryKey(id);
        return content;
    }

    @Override
    public List<Content> findByParams(Map<String, Object> params, RowBounds rowBounds) {
        return PaginationUtils.isPagination(rowBounds)
                ? contentMapper.findByParams(params,rowBounds)
                : contentMapper.findByParams(params);
    }

    @Override
    public List<MappingDetailDto> findWithTaxoInfo(Map<String,Object> params) {
        return mappingMapper.findWithTaxoInfo(params);
    }
}
