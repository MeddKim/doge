package com.doge.blog.mapper;

import com.doge.blog.domain.Content;

import java.util.List;

public interface ContentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Content record);

    int insertSelective(Content record);

    Content selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Content record);

    int updateByPrimaryKey(Content record);

    Content selectContentMappingById(Long id);

    List<Content> selectContentList();

}