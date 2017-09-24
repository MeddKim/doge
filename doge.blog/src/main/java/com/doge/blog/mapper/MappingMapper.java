package com.doge.blog.mapper;

import com.doge.blog.domain.Mapping;
import com.doge.blog.domain.dto.MappingDetailDto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface MappingMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Mapping record);

    int insertSelective(Mapping record);

    Mapping selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Mapping record);

    int updateByPrimaryKey(Mapping record);

    List<MappingDetailDto> findWithTaxoInfo(Map<String,Object> params);

}