package com.doge.blog.mapper;

import com.doge.blog.domain.Option;
import org.springframework.stereotype.Repository;

@Repository
public interface OptionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Option record);

    int insertSelective(Option record);

    Option selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Option record);

    int updateByPrimaryKeyWithBLOBs(Option record);

    int updateByPrimaryKey(Option record);
}