package com.doge.blog.mapper;

import com.doge.blog.domain.Mapping;

public interface MappingMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Mapping record);

    int insertSelective(Mapping record);

    Mapping selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Mapping record);

    int updateByPrimaryKey(Mapping record);
}