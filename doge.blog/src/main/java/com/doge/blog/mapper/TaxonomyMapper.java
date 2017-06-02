package com.doge.blog.mapper;

import com.doge.blog.domain.Taxonomy;

import java.util.List;

public interface TaxonomyMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Taxonomy record);

    int insertSelective(Taxonomy record);

    Taxonomy selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Taxonomy record);

    int updateByPrimaryKeyWithBLOBs(Taxonomy record);

    int updateByPrimaryKey(Taxonomy record);

    List<Taxonomy> selectTaxoList();
}