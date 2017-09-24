package com.doge.blog.mapper;

import com.doge.blog.domain.Content;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ContentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Content record);

    int insertSelective(Content record);

    Content selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Content record);

    int updateByPrimaryKey(Content record);

    Content selectContentMappingById(Long id);

    List<Content> selectContentList();

    List<Content> findByParams(Map<String,Object> params, RowBounds rowBounds);

    List<Content> findByParams(Map<String,Object> params);
}