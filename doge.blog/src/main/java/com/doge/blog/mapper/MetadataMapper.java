package com.doge.blog.mapper;

import com.doge.blog.domain.Metadata;
import org.springframework.stereotype.Repository;

@Repository
public interface MetadataMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Metadata record);

    int insertSelective(Metadata record);

    Metadata selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Metadata record);

    int updateByPrimaryKeyWithBLOBs(Metadata record);

    int updateByPrimaryKey(Metadata record);
}